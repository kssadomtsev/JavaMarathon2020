package day11;

public abstract class Employee {
    double salary;
    Warehouse warehouse;

    public Employee(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public double getSalary() {
        return salary;
    }
}
