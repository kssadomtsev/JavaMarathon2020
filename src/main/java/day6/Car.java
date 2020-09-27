package day6;

import java.time.Year;

public class Car {
    private Year yearProduction;
    private String color;
    private String model;

    public void info() {
        System.out.println("Это автомобиль");
    }

    public int yearDifference(int year) {
        return Math.abs(yearProduction.compareTo(Year.of(year)));
    }

    public Year getYearProduction() {
        return yearProduction;
    }

    public void setYearProduction(int yearProduction) {
        this.yearProduction = Year.of(yearProduction);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
