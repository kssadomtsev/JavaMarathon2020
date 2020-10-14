package FinalProject.model;

public class BattleField {
    private final Coordinate[][] field = new Coordinate[10][10];

    public BattleField() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                field[i][j] = new Coordinate(i, j, CoordinateState.AVAILABLE);
            }
        }
    }

    public void printField() {
        System.out.println("  0 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < field.length; i++) {
            StringBuilder builder = new StringBuilder();
            builder.append(i);
            for (int j = 0; j < field[i].length; j++) {
                builder.append(" ").append(field[i][j].getCoordinateState().getFigure());
            }
            System.out.println(builder);
        }
    }

    public Coordinate getSpecificCoordinate(int x, int y) {
        return field[y][x];
    }

}
