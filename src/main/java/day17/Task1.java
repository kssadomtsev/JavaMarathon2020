package day17;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Task1 {
    public static void main(String[] args) {
        ChessPiece[] chessPieces = new ChessPiece[8];
        IntStream.range(0, 4).forEach(i -> chessPieces[i] = ChessPiece.PAWN_WHITE);
        IntStream.range(4, 8).forEach(i -> chessPieces[i] = ChessPiece.ROOK_BLACK);
        Arrays.stream(chessPieces).forEach(chessPiece -> System.out.print(chessPiece.getFigure() + " "));
    }
}
