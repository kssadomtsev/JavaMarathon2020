package day7;

public class Task1 {
    public static void main(String[] args) {
        Airplane a1 = new Airplane("boeing", 1990, 20000, 60000);
        Airplane a2 = new Airplane("boeing", 1990, 21000, 60000);
        Airplane.compareAirplanes(a1, a2);
        Airplane.compareAirplanes(a2, a1);
    }
}