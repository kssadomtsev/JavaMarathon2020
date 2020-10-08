package day17;

public enum ChessPiece {
    KING_WHITE("♔", 100), KING_BLACK("♚", 100), QUEEN_WHITE("♕", 9), QUEEN_BLACK("♛", 9),
    ROOK_WHITE("♖", 5), ROOK_BLACK("♜", 5), BISHOP_WHITE("♗", 3.5F), BISHOP_BLACK("♝", 3.5F),
    KNIGHT_WHITE("♘", 3), KNIGHT_BLACK("♞", 3), PAWN_WHITE("♙", 1), PAWN_BLACK("♟", 1),
    EMPTY("_", -1);

    private String figure;
    private float value;

    ChessPiece(String figure, float value) {
        this.figure = figure;
        this.value = value;
    }

    public String getFigure() {
        return figure;
    }

    public static ChessPiece getChessPiece(String figure) {
        for (ChessPiece chessPiece : values()) {
            if (chessPiece.figure.equals(figure)) {
                return chessPiece;
            }
        }
        throw new IllegalArgumentException(figure);
    }
}
