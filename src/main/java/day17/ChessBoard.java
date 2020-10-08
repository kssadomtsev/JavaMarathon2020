package day17;

public class ChessBoard {
    private ChessPiece[][] board;

    public ChessBoard(ChessPiece[][] board) {
        this.board = board;
    }

    public void print() {
        for (ChessPiece[] chessPieces : board) {
            for (ChessPiece chessPiece : chessPieces) {
                System.out.print(chessPiece.getFigure());
            }
            System.out.println();
        }
    }
}
