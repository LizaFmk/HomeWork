package Homework2;

public class Task5 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 0, 0}, {1, 1, 1, 1, 0}, {1, 1, 1, 1, 1}};
        boolean lowerTriangularMatrix = true;
        search: for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    lowerTriangularMatrix = false;
                    break search;
                }
            }
        }

        System.out.println(lowerTriangularMatrix);
    }
}
