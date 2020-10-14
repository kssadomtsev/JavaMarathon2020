package FinalProject.model;

public enum CoordinateState {
//    SHIP("занято кораблем", "\uD83D\uDEE5"), AUREOLE("ореол корабля","\uD83D\uDFE6"),
//    AVAILABLE("доступно","\uD83D\uDFE9"), DESTROYED("уничтоженный корабль","\uD83D\uDFE5");
    SHIP("занято кораблем", "#"), AUREOLE("ореол корабля","*"),
    AVAILABLE("доступно","⬜"), DESTROYED("уничтоженный корабль","X");

    private String description;
    private String figure;


    CoordinateState(String description, String figure) {
        this.description = description;
        this.figure = figure;
    }

    public String getFigure() {
        return figure;
    }

    public String getDescription() {
        return description;
    }
}
