package day8;

public class Task1 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String result = "";
        for (int i = 0; i < 20001; i++) {
            result = result + " " + i;
        }
        long finish = System.currentTimeMillis();
        long timeConsumedMillis = finish - start;
        //System.out.println(result);
        System.out.println("Concat with String consumed: " + timeConsumedMillis);
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 20001; i++) {
            sb.append(" ").append(i);
        }
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        //System.out.println(sb);
        System.out.println("Concat with StringBuilder consumed: " + timeConsumedMillis);
    }
}
