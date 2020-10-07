package day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");
        try {
            PrintWriter printWriter = new PrintWriter(file1);
            for (int i = 0; i < 1000; i++) {
                printWriter.print((int) (Math.random() * 100) + " ");
            }
            printWriter.close();
            printWriter = new PrintWriter(file2);
            Scanner scanner = new Scanner(file1).useDelimiter(" ");
            int i = 0;
            int sum = 0;
            while (scanner.hasNext()) {
                sum += scanner.nextInt();
                i++;
                if (i == 20) {
                    printWriter.print((double) sum / i + " ");
                    i = 0;
                    sum = 0;
                }
            }
            printWriter.close();
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        printResult(file2);
    }

    public static void printResult(File file) {
        try (Scanner scanner = new Scanner(file)) {
            String line = scanner.nextLine();
            String[] numbersString = line.split(" ");
            double sum = Arrays.stream(numbersString).map(Double::parseDouble).reduce(0.0, Double::sum);
            int sumInt = (int) sum;
            System.out.println(sumInt);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
