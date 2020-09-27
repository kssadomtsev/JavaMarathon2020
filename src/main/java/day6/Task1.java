package day6;

public class Task1 {
    public static void main(String[] args) {
        Car car = new Car();
        car.setYearProduction(1980);
        car.setColor("Black");
        car.setModel("A8");
        car.info();
        System.out.println(car.yearDifference(1970));

        Motorbike motorbike = new Motorbike(1975, "Black", "Ural");
        motorbike.info();
        System.out.println(motorbike.yearDifference(2020));
    }
}

