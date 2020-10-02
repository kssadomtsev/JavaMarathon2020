package day11;

public class Courier extends Employee implements Worker {
    public Courier(Warehouse warehouse) {
        super(warehouse);
    }

    @Override
    public void doWork() {
        super.salary += 100;
        super.warehouse.setBalance(super.warehouse.getBalance() + 1000);
        bonus();
    }

    @Override
    public void bonus() {
        if (super.warehouse.getBalance() % 1000000 == 0) {
            super.salary = 100 * 2 * ((double) super.warehouse.getBalance() / 1000000);
        }
    }
}
