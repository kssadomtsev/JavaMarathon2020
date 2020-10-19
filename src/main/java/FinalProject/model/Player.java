package FinalProject.model;

import FinalProject.exceptions.NonCoordinateException;
import FinalProject.utils.Validator;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Player {
    private String name;
    private List<Ship> ships;
    private BattleField battleField;
    private int aliveShipCount;

    public Player(String name) {
        this.name = name;
        battleField = new BattleField();
    }

    public void placeShips() {
        Scanner scanner = new Scanner(System.in);
        // Init empty list of ships
        ships = new ArrayList<>();
        for (ShipType shipType : ShipType.values()) {
            // Create coordinate view
            String stringBuilder = IntStream.range(1, shipType.getSize()).mapToObj(j -> ";x,y").collect(Collectors.joining("", "x,y", ""));
            System.out.println("Введи координаты " + shipType.getTypeForm2() + " (формат: " + stringBuilder + ")");
            Ship nextShip = null;
            while (nextShip == null && scanner.hasNext()) {
                String input = scanner.nextLine();
                try {
                    nextShip = Validator.validateShipPlace(battleField, shipType, input);
                } catch (InputMismatchException inputMismatchException) {
                    System.out.println("Неверное количество агрументов, разделенных \";\". Повторите ввод");
                }

            }
            ships.add(nextShip);
            placeShipOnBattleField(nextShip);
        }
        System.out.println("Текущий вид поля:");
        battleField.printField();
        //Sync all ships with field
        syncShipWithBattledField();
        // Count all alive ships
        updateShipsStatus();
        System.out.println("Количество живых кораблей: " + aliveShipCount);
    }

    public void placeShipOnBattleField(Ship ship) {
        // We already validated that ship can be placed on provided coordinates
        // Mark coordinates on battlefield with ship itself
        List<Coordinate> coordinates = ship.getCoordinates();
        coordinates.forEach(coordinate -> battleField.getSpecificCoordinate(coordinate.getX(), coordinate.getY()).setCoordinateState(CoordinateState.SHIP));
        // Now set aureole of ship
        if (ship.isVertical()) {
            if (coordinates.get(0).getX() >= 1) {
                // Set aureole on the left side of ship
                IntStream.range(coordinates.get(coordinates.size() - 1).getY(), coordinates.get(0).getY() + 1).forEach(i -> battleField.getSpecificCoordinate(coordinates.get(0).getX() - 1, i).setCoordinateState(CoordinateState.AUREOLE));
            }
            if (coordinates.get(0).getX() <= 8) {
                // Set aureole on the right side of ship
                IntStream.range(coordinates.get(coordinates.size() - 1).getY(), coordinates.get(0).getY() + 1).forEach(i -> battleField.getSpecificCoordinate(coordinates.get(0).getX() + 1, i).setCoordinateState(CoordinateState.AUREOLE));
            }
            if (coordinates.get(coordinates.size() - 1).getY() >= 1) {
                // Set aureole on the top side of ship
                int leftX = coordinates.get(0).getX() == 0 ? 0 : coordinates.get(0).getX() - 1;
                int rightX = coordinates.get(0).getX() == 9 ? 9 : coordinates.get(0).getX() + 1;
                IntStream.range(leftX, rightX + 1).forEach(i -> battleField.getSpecificCoordinate(i, coordinates.get(coordinates.size() - 1).getY() - 1).setCoordinateState(CoordinateState.AUREOLE));
            }
            if (coordinates.get(0).getY() <= 8) {
                // Set aureole on the bottom side of ship
                int leftX = coordinates.get(0).getX() == 0 ? 0 : coordinates.get(0).getX() - 1;
                int rightX = coordinates.get(0).getX() == 9 ? 9 : coordinates.get(0).getX() + 1;
                IntStream.range(leftX, rightX + 1).forEach(i -> battleField.getSpecificCoordinate(i, coordinates.get(0).getY() + 1).setCoordinateState(CoordinateState.AUREOLE));
            }
        } else {
            if (coordinates.get(0).getY() >= 1) {
                // Set aureole on the top side of ship
                IntStream.range(coordinates.get(coordinates.size() - 1).getX(), coordinates.get(0).getX() + 1).forEach(i -> battleField.getSpecificCoordinate(i, coordinates.get(0).getY() - 1).setCoordinateState(CoordinateState.AUREOLE));
            }
            if (coordinates.get(0).getY() <= 8) {
                // Set aureole on the bottom side of ship
                IntStream.range(coordinates.get(coordinates.size() - 1).getX(), coordinates.get(0).getX() + 1).forEach(i -> battleField.getSpecificCoordinate(i, coordinates.get(0).getY() + 1).setCoordinateState(CoordinateState.AUREOLE));
            }
            if (coordinates.get(coordinates.size() - 1).getX() >= 1) {
                // Set aureole on the left side of ship
                int topY = coordinates.get(0).getY() == 0 ? 0 : coordinates.get(0).getY() - 1;
                int bottomY = coordinates.get(0).getY() == 9 ? 9 : coordinates.get(0).getY() + 1;
                IntStream.range(topY, bottomY + 1).forEach(i -> battleField.getSpecificCoordinate(coordinates.get(coordinates.size() - 1).getX() - 1, i).setCoordinateState(CoordinateState.AUREOLE));
            }
            if (coordinates.get(0).getX() <= 8) {
                // Set aureole on the right side of ship
                int topY = coordinates.get(0).getY() == 0 ? 0 : coordinates.get(0).getY() - 1;
                int bottomY = coordinates.get(0).getY() == 9 ? 9 : coordinates.get(0).getY() + 1;
                IntStream.range(topY, bottomY + 1).forEach(i -> battleField.getSpecificCoordinate(coordinates.get(0).getX() + 1, i).setCoordinateState(CoordinateState.AUREOLE));
            }

        }
    }

    public String attacked(Coordinate coordinate) {
        Coordinate playerCoordinate = battleField.getSpecificCoordinate(coordinate.getX(), coordinate.getY());
        if (playerCoordinate.getCoordinateState() == CoordinateState.SHIP) {
            battleField.getSpecificCoordinate(coordinate.getX(), coordinate.getY()).setCoordinateState(CoordinateState.DESTROYED);
            int aliveShipCountBeforeAttack = aliveShipCount;
            //Sync all ships with field
            syncShipWithBattledField();
            // Count all alive ships
            updateShipsStatus();
            if (aliveShipCount < aliveShipCountBeforeAttack) {
                return "Утопил!";
            } else {
                return "Попадание!";
            }
        } else {
            return "Мимо!";
        }

    }

    //Method to sync ship cell status with actual BattledField
    public void syncShipWithBattledField() {
        for (Ship ship : ships) {
            for (Coordinate coordinate : ship.getCoordinates()) {
                coordinate.setCoordinateState(battleField.getSpecificCoordinate(coordinate.getX(), coordinate.getY()).getCoordinateState());
            }
        }
    }

    // Method to count actual alive ship count
    public void updateShipsStatus() {
        int aliveShipCount = 0;
        for (Ship ship : ships) {
            ship.checkAlive();
            if (ship.isAlive()) {
                aliveShipCount++;
            }
        }
        this.aliveShipCount = aliveShipCount;
    }

    public String getName() {
        return name;
    }

    public int getAliveShipCount() {
        return aliveShipCount;
    }

    public BattleField getBattleField() {
        return battleField;
    }

    public void setBattleField(BattleField battleField) {
        this.battleField = battleField;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }
}
