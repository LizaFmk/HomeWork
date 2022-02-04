package Homework2;

public class Task6 {
    public static void main(String[] args) {
        int[][] firstMatrix = {{1, 2, 3}, {3, 2, 1}, {1, 2, 3}};
        int[][] secondMatrix = {{1, 2, 3}, {3, 2, 1}, {1, 2, 3}};
        int[][] resultMatrixPlus = new int[firstMatrix.length][firstMatrix[0].length];
        int[][] resultMatrixMinus = new int[firstMatrix.length][firstMatrix[0].length];

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[i].length; j++) {
                resultMatrixPlus[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
                resultMatrixMinus[i][j] = firstMatrix[i][j] - secondMatrix[i][j];
            }
        }
    }
}
