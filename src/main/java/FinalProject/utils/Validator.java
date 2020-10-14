package FinalProject.utils;

import FinalProject.exceptions.NonAvailableCoordinateException;
import FinalProject.exceptions.NonCoordinateException;
import FinalProject.exceptions.NonCorrectShipForm;
import FinalProject.model.*;

import java.util.*;

public class Validator {

    public static Ship validateShipPlace(BattleField battleField, ShipType shipType, String input) {
        try {
            // Check that was provided needed number of words separated with ";"
            String[] expected = input.split(";");
            if (expected.length != shipType.getSize()) {
                throw new InputMismatchException();
            }
            // Check that all coordinates has valid format
            for (String str : expected) {
                if (!validateCoordinate(str)) {
                    return null;
                }
            }
            // Cast strings to coordinate objects
            List<Coordinate> coordinates = new ArrayList<>(expected.length);
            for (String str : expected) {
                coordinates.add(getCoordinateFromString(str));
            }
            // Check that all coordinates are available for place ship
            for (Coordinate coordinate : coordinates) {
                if (!isAvailableCoordinate(coordinate, battleField)) {
                    return null;
                }
            }
            // Check that coordinates can be used to create correct ship form
            return isCorrectShip(coordinates, shipType);
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("Неверное количество агрументов, разделенных \";\". Повторите ввод");
            return null;
        }
    }

    public static boolean validateCoordinate(String coordinate) {
        try {
            String[] positionAsStrings = coordinate.split(",");
            if (positionAsStrings.length != 2 || (!isNumeric(positionAsStrings[0]) || !isNumeric(positionAsStrings[1]))) {
                throw new NonCoordinateException();
            }
            for (String str : positionAsStrings) {
                int d = Integer.parseInt(str);
                if (d < 0 || d > 9) {
                    throw new NonCoordinateException();
                }
            }
            return true;
        } catch (NonCoordinateException nonCoordinateException) {
            System.out.println("Невереный формат ввода одной из координат. Корректный формат 0-9,0-9. Повторите ввод");
            return false;
        }
    }

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            System.out.println("Для задания координаты использованы не целые числа. Повторите ввод");
            return false;
        }
        return true;
    }

    public static Coordinate getCoordinateFromString(String coordinate) {
        String[] positionAsStrings = coordinate.split(",");
        return new Coordinate(Integer.parseInt(positionAsStrings[0]), Integer.parseInt(positionAsStrings[1]), CoordinateState.AVAILABLE);
    }

    private static boolean isAvailableCoordinate(Coordinate coordinate, BattleField battleField) {
        try {
            CoordinateState actualState = battleField.getSpecificCoordinate(coordinate.getX(), coordinate.getY()).getCoordinateState();
            if (actualState != CoordinateState.AVAILABLE) {
                throw new NonAvailableCoordinateException(actualState.getDescription());
            }
            return true;
        } catch (NonAvailableCoordinateException nonAvailableCoordinateException) {
            System.out.println("Координата " + coordinate.getX() + ", " + coordinate.getY() + " не может быть использована по причине: " + nonAvailableCoordinateException.getMessage());
            System.out.println("Текущий вид поля:");
            battleField.printField();
            return false;
        }
    }

    private static Ship isCorrectShip(List<Coordinate> coordinates, ShipType shipType) {
        try {
            //At first we should check that all coordinates lies on one line
            boolean isHorizontal = coordinates.stream().map(Coordinate::getY).distinct().allMatch(e -> e.equals(coordinates.get(0).getY()));
            boolean isVertical = coordinates.stream().map(Coordinate::getX).distinct().allMatch(e -> e.equals(coordinates.get(0).getX()));
            if (isHorizontal && (!isVertical)) {
                // This is horizontal ship! Now we should sort list DESC because coordinates can be provided in different order
                coordinates.sort(Comparator.comparing(Coordinate::getX).reversed());
                //Now we should check that difference between to nearest X-pos only 1
                for (int i = 0; i < coordinates.size() - 1; i++) {
                    if (coordinates.get(i).getX() - coordinates.get(i + 1).getX() != 1) {
                        throw new NonCorrectShipForm();
                    }
                }
            } else if (isVertical && (!isHorizontal)) {
                // This is vertical ship! Now we should sort list DESC because coordinates can be provided in different order
                coordinates.sort(Comparator.comparing(Coordinate::getY).reversed());
                //Now we should check that difference between to nearest Y-pos only 1
                for (int i = 0; i < coordinates.size() - 1; i++) {
                    if (coordinates.get(i).getY() - coordinates.get(i + 1).getY() != 1) {
                        throw new NonCorrectShipForm();
                    }
                }
            } else if (shipType.getSize() > 1) { // exclude case when ship consist only one cell
                throw new NonCorrectShipForm();
            }
            return new Ship(shipType, coordinates, true, isVertical);
        } catch (NonCorrectShipForm nonCorrectShipForm) {
            System.out.println("Введенные координаты не могут образовать корабль корректной формы. Повторите ввод.");
            return null;
        }
    }
}
