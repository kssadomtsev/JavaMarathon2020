package day4;

public class Task2 {
    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10000);
        }
        int max = array[0], min = array[0], endedWithZero = 0, sumOfEndedWithZero = 0;
        for (int a : array) {
            if (a < min) {
                min = a;
            }
            if (a > max) {
                max = a;
            }
            if (a % 10 == 0) {
                endedWithZero++;
                sumOfEndedWithZero += a;
            }
        }
        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
        System.out.println("endedWithZero count: " + endedWithZero);
        System.out.println("sumOfEndedWithZero: " + sumOfEndedWithZero);
    }
}
