package Homework2;

public class Task1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = 7;
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != n) {
                sum += arr[i];
            }
        }
    }
}
