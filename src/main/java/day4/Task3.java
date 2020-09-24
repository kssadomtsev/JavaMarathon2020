package day4;

import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        int[][] matrix = new int[12][8];
        int maxSumOfRow = 0, index = 0;
        for (int i = 0; i < matrix.length; i++) {
            int sumOfRow = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 50);
                sumOfRow += matrix[i][j];
            }
            if (sumOfRow > maxSumOfRow) {
                maxSumOfRow = sumOfRow;
                index = i;
            }
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println(index);
    }
}
