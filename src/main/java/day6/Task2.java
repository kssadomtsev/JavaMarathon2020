package day6;

public class Task2 {
    public static void main(String[] args) {
        Airplane a = new Airplane("boeing", 1990, 20000, 60000);
        a.info();
        a.fillUp(120);
        a.setYear(2000);
        a.setLength(30000);
        a.fillUp(100);
        a.info();
    }
}
