package day4;

public class Task4 {
    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 10000);
        }
        int index = 0, maxSumOfThree = 0;
        for (int i = 0; i < array.length - 2; i++) {
            int sum = 0;
            for (int j = i; j < i + 3; j++) {
                sum += array[j];
            }
            if (sum > maxSumOfThree) {
                maxSumOfThree = sum;
                index = i;
            }
        }
        System.out.println(maxSumOfThree);
        System.out.println(index);
    }
}
