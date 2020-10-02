package day11;

public class Task1 {
    public static void main(String[] args) {
        Warehouse w = new Warehouse();
        Courier courier = new Courier(w);
        courier.doWork();
        System.out.println(courier.getSalary());
        w.setBalance(999_999);
        System.out.println(w.getBalance());
        courier.bonus();
        System.out.println(courier.getSalary());

    }
}
