package FinalProject.model;

public class Coordinate {
    private int x;
    private int y;
    private CoordinateState coordinateState;

    public Coordinate(int x, int y, CoordinateState coordinateState) {
        this.x = x;
        this.y = y;
        this.coordinateState = coordinateState;
    }

    public CoordinateState getCoordinateState() {
        return coordinateState;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setCoordinateState(CoordinateState coordinateState) {
        this.coordinateState = coordinateState;
    }

    public void print() {
        System.out.println("x: " + x + ", y: " + y);
    }
}
