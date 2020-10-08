package day17;

public class Task2 {
    public static void main(String[] args) {
        String initialBoard = "♜____♜♚__♖__♟♟_♟♟_♞___♟_♛__♗_______♝♙_______♗♙__♙__♕_♙_♙_____♖♔_";
        ChessPiece[][] board = new ChessPiece[8][8];
        int index = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ChessPiece.getChessPiece(initialBoard.substring(index, index + 1));
                index++;
            }
        }
        ChessBoard chessBoard = new ChessBoard(board);
        chessBoard.print();
    }
}
