package day5;

import java.time.Year;

public class Task1 {
    public static void main(String[] args) {
        Car car = new Car();
        car.setYearProduction(Year.of(1980));
        car.setColor("Black");
        car.setModel("A8");
        System.out.println("Car attributes.");
        System.out.println("Year of production: " + car.getYearProduction());
        System.out.println("Color: " + car.getColor());
        System.out.println("Model: " + car.getModel());
    }
}

class Car {
    private Year yearProduction;
    private String color;
    private String model;

    public Year getYearProduction() {
        return yearProduction;
    }

    public void setYearProduction(Year yearProduction) {
        this.yearProduction = yearProduction;
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
