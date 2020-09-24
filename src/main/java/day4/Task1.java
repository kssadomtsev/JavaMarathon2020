package day4;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lengthOfArray = scanner.nextInt();
        int[] array = new int[lengthOfArray];
        int sum = 0, greatThanEight = 0, equalsOne = 0, oddCount = 0, evenCount = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10);
            sum += array[i];
            if (array[i] == 1) {
                equalsOne++;
            } else if (array[i] > 8) {
                greatThanEight++;
            }
            if (array[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
            System.out.print(array[i] + " ");
        }
        System.out.println("\n" + "Длина массива:" + lengthOfArray);
        System.out.println("Количество чисел больше 8: " + greatThanEight);
        System.out.println("Количество чисел равных 1: " + equalsOne);
        System.out.println("Количество четных чисел: " + evenCount);
        System.out.println("Количество нечетных чисел: " + oddCount);
        System.out.println("Сумма всех элементов массива: " + sum);
    }
}
