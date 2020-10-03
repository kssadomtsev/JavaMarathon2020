package day12;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Task2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        IntStream.range(0, 31).filter(x -> x % 2 == 0).forEach(list::add);
        IntStream.range(300, 351).filter(x -> x % 2 == 0).forEach(list::add);
        list.forEach(System.out::println);
    }
}
