package Homework2;

public class Task2 {
    public static void main(String[] args) {
        int n = 7;
        int sum = 0;
        int a = 0;
        int b = 1;
        for (int i = 0; i <= n; i++) {
            int next = a + b;
            a = b;
            b = next;
            if (a % 2 == 0) {
                sum += a;
            }
        }
        System.out.println(sum);
    }
}
