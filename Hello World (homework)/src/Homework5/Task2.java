package Homework5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task2 {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        printMultiplicationOfMatrices(readTheMatrix(2), readTheMatrix(2));

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[][] readTheMatrix(Integer length) {

        int[][] matrix = new int[length][length];

        System.out.println("Введите значения матрицы. Длина строки: " + length);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                try {
                    matrix[i][j] = Integer.parseInt(reader.readLine());
                } catch (NumberFormatException numberFormatException) {
                    System.err.println("Нужно вводить числа");
                    readTheMatrix(length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return matrix;
    }

    public static void printMultiplicationOfMatrices(int[][] matrixOne, int[][] matrixTwo) {

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                try {
                    System.out.print(matrixOne[i][j] * matrixTwo[i][j] + " ");
                } catch (NullPointerException e) {
                    System.err.println("Произошла ошибка");
                    break;
                }
            }
            System.out.println("");
        }
    }
}