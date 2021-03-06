package day11;

public class Picker extends Employee implements Worker {
    public Picker(Warehouse warehouse) {
        super(warehouse);
    }

    @Override
    public void doWork() {
        super.salary += 80;
        super.warehouse.setCountOrders(super.warehouse.getCountOrders() + 1);
        bonus();
    }

    @Override
    public void bonus() {
        if (super.warehouse.getCountOrders() % 1500 == 0) {
            int score = super.warehouse.getCountOrders() / 1500;
            if (super.gotBonuses < score) {
                super.salary = super.salary * 3;
                super.gotBonuses = score;
            }
        }
    }
}
