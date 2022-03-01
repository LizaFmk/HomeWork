package Homework5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task6 {
    // если матрицы в файле записаны друг под другом и разделены одной пустой строкой

    private static int[][] matrixOne;
    private static int[][] matrixTwo;
    private static final List<String> fileLineByLine = new ArrayList<>();
    private static final File INPUT_FILE = new File("/Users/lizafomichenok/Documents/Разработка/INPUTFILE.txt");

    public static void main(String[] args) {
        String line;
        int index = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(INPUT_FILE)))) {
            while ((line = reader.readLine()) != null) {
                fileLineByLine.add(line);
            }

            if (fileLineByLine.size() != 0) {
                index = (fileLineByLine.size() - 1) / 2;
                matrixOne = new int[index][index];
                matrixTwo = new int[index][index];
            } else {
                System.err.println("Файл не содержит матриц");
                System.exit(0);
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] row;

        for (int i = 0; i < index; i++) {
            row = fileLineByLine.get(i).split(" ");
            for (int j = 0; j < row.length; j++) {
                matrixOne[i][j] = Integer.parseInt(row[j]);
            }
        }

        for (int i = index + 1; i < fileLineByLine.size(); i++) {
            row = fileLineByLine.get(i).split(" ");
            for (int j = 0; j < row.length; j++) {
                matrixTwo[i - (index + 1)][j] = Integer.parseInt(row[j]);
            }
        }

        printMatrix(matrixOne);
        printMatrix(matrixTwo);
        printMultiplicationOfMatrices(matrixOne, matrixTwo);

    }

    public static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println("");
        }
        System.out.println("");
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
