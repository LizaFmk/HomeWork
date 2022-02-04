package Homework2;

public class Task3 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int[] arrInvert = new int[arr.length];
        for (int i = 0, j = arr.length - 1; i < arr.length; i++, j--) {
            arrInvert[j] = arr[i];
        }
    }
}
