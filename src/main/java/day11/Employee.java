package day11;

public abstract class Employee {
    protected double salary;
    protected Warehouse warehouse;
    protected int gotBonuses;

    public Employee(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public double getSalary() {
        return salary;
    }
}
