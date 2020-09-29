package day8;

import java.time.Year;

public class Airplane {
    private String producer;
    private Year year;
    private int length;
    private int weight;
    private int fuel;

    public Airplane(String producer, int year, int length, int weight) {
        this.producer = producer;
        this.year = Year.of(year);
        this.length = length;
        this.weight = weight;
        this.fuel = 0;
    }

    public void setYear(int year) {
        this.year = Year.of(year);
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getFuel() {
        return fuel;
    }

    public void info() {
        System.out.println("Изготовитель: " + producer + ", год выпуска: " + year + ", длина: " + length + ", вес: " + weight + ", количество топлива в баке: " + fuel);
    }

    public void fillUp(int extrafuel) {
        fuel += extrafuel;
    }

    @Override
    public String toString() {
        return "Изготовитель: " + producer + ", год выпуска: " + year + ", длина: " + length + ", вес: " + weight + ", количество топлива в баке: " + fuel;
    }
}
