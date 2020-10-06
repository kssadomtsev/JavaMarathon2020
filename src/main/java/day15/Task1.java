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
            List<String[]> shoes = new ArrayList<>();
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] shoe = line.split(";");
                if (Integer.parseInt(shoe[2]) == 0) {
                    shoes.add(shoe);
                }
            }
            scanner.close();
            PrintWriter printWriter = new PrintWriter(output);
            for (String[] shoe : shoes) {
                printWriter.println(String.join(", ", shoe));
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
