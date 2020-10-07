package day15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        File input = new File("src/main/resources/shoes.csv");
        File output = new File("src/main/resources/missing_shoes.txt");
        try {
            Scanner scanner = new Scanner(input);
            PrintWriter printWriter = new PrintWriter(output);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] shoe = line.split(";");
                if (Integer.parseInt(shoe[2]) == 0) {
                    printWriter.println(String.join(", ", shoe));
                }
            }
            scanner.close();
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
