package day6;

import java.time.Year;

public class Motorbike {
    private Year yearProduction;
    private String color;
    private String model;

    public Motorbike(int yearProduction, String color, String model) {
        this.yearProduction = Year.of(yearProduction);
        this.color = color;
        this.model = model;
    }

    public void info() {
        System.out.println("Это мотоцикл");
    }

    public int yearDifference(int year) {
        return Math.abs(yearProduction.compareTo(Year.of(year)));
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
