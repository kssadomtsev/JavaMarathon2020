package FinalProject.model;

import java.util.List;

public class Ship {
    private List<Coordinate> coordinates;
    private ShipType shipType;
    private boolean alive;
    private boolean isVertical;


    public Ship(ShipType shipType, List<Coordinate> coordinates, boolean alive, boolean isVertical) {
        this.shipType = shipType;
        this.alive = alive;
        this.coordinates = coordinates;
        this.isVertical = isVertical;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public boolean isAlive() {
        return alive;
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }

    public boolean isVertical() {
        return isVertical;
    }

    public void print() {
        System.out.println("Ship " + shipType + ", is alive: " + alive + ", is it vertical: " + isVertical);
        coordinates.forEach(Coordinate::print);
    }

    public void checkAlive() {
        // if any cell is alive ship is still alive
        alive = coordinates.stream().anyMatch(x -> x.getCoordinateState() == CoordinateState.SHIP);
    }
}
