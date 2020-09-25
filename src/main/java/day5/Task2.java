package day5;

import java.time.Year;

public class Task2 {
    public static void main(String[] args) {
        Motorbike motorbike = new Motorbike(Year.of(1975), "Black", "Ural");
        System.out.println("Motorbike attributes.");
        System.out.println("Year of production: " + motorbike.getYearProduction());
        System.out.println("Color: " + motorbike.getColor());
        System.out.println("Model: " + motorbike.getModel());

    }
}

class Motorbike {
    private Year yearProduction;
    private String color;
    private String model;

    public Motorbike(Year yearProduction, String color, String model) {
        this.yearProduction = yearProduction;
        this.color = color;
        this.model = model;
    }

    public Year getYearProduction() {
        return yearProduction;
    }

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }
}