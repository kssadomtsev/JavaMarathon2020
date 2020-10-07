package day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        File file = new File("data1");
        printResult(file);
    }

    public static void printResult(File file) {
        try (Scanner scanner = new Scanner(file)) {
            String line = scanner.nextLine();
            String[] numbersString = line.split(" ");
            double avg = Arrays.stream(numbersString).map(Double::parseDouble).reduce(0.0, Double::sum) / numbersString.length;
            String avgFormatted = String.format("%.3f", avg);
            System.out.print(avg + " --> " + avgFormatted);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }
}
