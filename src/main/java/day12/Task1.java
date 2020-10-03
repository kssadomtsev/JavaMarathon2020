package day12;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hundai");
        list.add("Kia");
        list.add("BMW");
        list.add("Audi");
        list.add("Nissan");
        list.forEach(System.out::println);
        System.out.println();
        list.add(2, "Toyota");
        list.remove(0);
        list.forEach(System.out::println);
    }
}
