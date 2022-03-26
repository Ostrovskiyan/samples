package com.aostrovskyi.samples.tasks.codewars;

public class MaxSubmatrix {

    public static void main(String[] args) {
        int[][] src = new int[][] {
                {2, 3, 4, 5, 6, 7, 8},
                {2, 3, 9, 8, 6, 7, 8},
                {2, 3, 8, 9, 6, 7, 8}
        };

        printMatrix(findSubmatrixForce(src, 2, 2));
    }

    public static int[][] findSubmatrixForce(int[][] matrix, int x, int y) {
        int[][] result = new int[x][y];
        int[][] tmp = new int[x][y];
        int maxSum = 0;

        for (int i = 0; i < x; i++) {
            System.arraycopy(matrix[i], 0, result[i], 0, y);
        }
        maxSum = matrixSum(result);

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m - x + 1; i++) {
            for (int j = 0; j < n - y + 1; j++) {

                for (int a = 0; a < x; a++) {
                    System.arraycopy(matrix[a + i], j, tmp[a], 0, y);
                }
                int posSum = matrixSum(tmp);
                if (posSum > maxSum) {
                    printMatrix(tmp);
                    System.out.println(maxSum + " " + posSum);
                    System.out.println();

                    maxSum = posSum;
                    result = tmp;
                }
            }
        }

        return result;
    }

    public static int findSubmatrixScreen(int[][] matrix, int x, int y) {
        int maxSum = 0;
        int rowSum, columnSum = 0;

        for (int i = 0; i < x; i++) {
//            System.arraycopy(matrix[i], 0, result[i], 0, y);
        }
//        maxSum = matrixSum(result);

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m - x + 1; i++) {
            rowSum = columnSum = matrixSum(matrix, i, 0, x, y);
            for (int j = 0; j < n - y + 1; j++) {

            }
        }

        return 0;
    }

    public static int matrixSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public static int matrixSum(int[][] matrix, int startX, int startY, int sizeX, int sizeY) {
        int sum = 0;
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                sum += matrix[i + startX][j + startY];
            }
        }
        return sum;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + ", ");
            }
            System.out.println();
        }
    }

}
