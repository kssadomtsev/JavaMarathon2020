package day11;

public class Warehouse {
    private int countOrder;
    private double balance;

    public int getCountOrders() {
        return countOrder;
    }

    public void setCountOrders(int countOrder) {
        this.countOrder = countOrder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "countOrder=" + countOrder +
                ", balance=" + balance +
                '}';
    }
}
