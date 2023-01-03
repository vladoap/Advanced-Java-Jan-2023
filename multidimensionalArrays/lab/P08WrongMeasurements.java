package multidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = readArray(scanner);
        }
        int[] wrongIndexes = readArray(scanner);

        int rowIndex = wrongIndexes[0];
        int colIndex = wrongIndexes[1];
        int wrongValue = matrix[rowIndex][colIndex];
        int[][] resultMatrix = new int[matrix.length][matrix[0].length];

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == wrongValue) {
                    int correctValue = getNearbySum(matrix, r, c, wrongValue);
                    resultMatrix[r][c] = correctValue;
                } else {
                    resultMatrix[r][c] = matrix[r][c];
                }
            }
        }

        printMatrix(resultMatrix);

    }

    private static void printMatrix(int[][] resultMatrix) {
        for (int[] arr : resultMatrix) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    private static int getNearbySum(int[][] matrix, int r, int c, int wrongValue) {
        int sum = 0;
        if (isInBounds(matrix, r, c - 1)) {
            int leftNum = matrix[r][c - 1];
            if (leftNum != wrongValue) {
                sum += leftNum;
            }
        }
        if (isInBounds(matrix, r, c + 1)) {
            int rightNum = matrix[r][c + 1];
            if (rightNum != wrongValue) {
                sum += rightNum;
            }

        }
        if (isInBounds(matrix, r - 1, c)) {
            int upperNum = matrix[r - 1][c];
            if (upperNum != wrongValue) {
                sum += upperNum;
            }
        }
        if (isInBounds(matrix, r + 1, c)) {
            int lowerNum = matrix[r + 1][c];
            if (lowerNum != wrongValue) {
                sum += lowerNum;
            }
        }

        return sum;
    }

    private static boolean isInBounds(int[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }

    private static boolean OutOfBounds(int[][] matrix, int r, int c) {
        return !isInBounds(matrix, r, c);
    }



    private static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }


}
