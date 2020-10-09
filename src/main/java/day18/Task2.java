package day18;

/**
 * @author Neil Alishev
 */
public class Task2 {
    public static void main(String[] args) {
        System.out.println(count7(717771237)); // 5
        System.out.println(count7(17771237));
        System.out.println(count7(1213212312));
        System.out.println(count7(7));
        System.out.println(count7(0));
    }

    public static int count7(int number) {
        if (number == 0) {
            return 0;
        }
        return (number % 10 == 7 ? 1 : 0) + count7(number / 10);
    }
}
