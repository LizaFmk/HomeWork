package Homework2;

public class Task4 {
    public static void main(String[] args) {
        int[][] matrix = {{-1, -2, -3}, {3, 2, 1}};
        int positiveCounter = 0, negativeCounter = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > 0) {
                    positiveCounter++;
                } else {
                    negativeCounter++;
                }
            }
        }
        if (positiveCounter > negativeCounter) {
            System.out.println("Положительных чисел больше");
        } else if (negativeCounter > positiveCounter) {
            System.out.println("Отрицательных чисел больше");
        } else {
            System.out.println("Количество положительных и отрицательных чисел одинаково");
        }
    }
}
