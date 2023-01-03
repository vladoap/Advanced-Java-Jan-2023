package multidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P07FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = new String[8][8];
        for (int arr = 0; arr < matrix.length; arr++) {
            matrix[arr] = scanner.nextLine().split("\\s+");
        }

        int[] queenIndexes = new int[2];
        boolean isFound = false;
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                if (matrix[rows][cols].equals("q")) {
                    isFound = isQueenPositionValid(matrix, rows, cols);
                }
                if (isFound) {
                    queenIndexes[0] = rows;
                    queenIndexes[1] = cols;
                    break;
                }
            }
            if (isFound) {
                break;
            }
        }

        if (isFound) {
            System.out.println(queenIndexes[0] + " " + queenIndexes[1]);
        }

    }

    private static boolean isQueenPositionValid(String[][] matrix, int rows, int cols) {
        int initialRowIndex = rows;
        int initialColIndex = cols;

        while (isInBounds(matrix, rows, cols - 1)) {
            if (matrix[rows][cols - 1].equals("q")) {
                return false;
            }
            cols--;
        }
        rows = initialRowIndex;
        cols = initialColIndex;
        while (isInBounds(matrix, rows, cols + 1)) {
            if (matrix[rows][cols + 1].equals("q")) {
                return false;
            }
            cols++;
        }

        rows = initialRowIndex;
        cols = initialColIndex;
        while (isInBounds(matrix, rows + 1, cols)) {
            if (matrix[rows + 1][cols].equals("q")) {
                return false;
            }
            rows++;
        }

        rows = initialRowIndex;
        cols = initialColIndex;
        while (isInBounds(matrix, rows - 1, cols)) {
            if (matrix[rows - 1][cols].equals("q")) {
                return false;
            }
            rows--;
        }

        rows = initialRowIndex;
        cols = initialColIndex;
        while (isInBounds(matrix, rows - 1, cols - 1)) {
            if (matrix[rows - 1][cols - 1].equals("q")) {
                return false;
            }
            cols--;
            rows--;
        }

        rows = initialRowIndex;
        cols = initialColIndex;
        while (isInBounds(matrix, rows + 1, cols + 1)) {
            if (matrix[rows + 1][cols + 1].equals("q")) {
                return false;
            }
            cols++;
            rows++;
        }

        rows = initialRowIndex;
        cols = initialColIndex;
        while (isInBounds(matrix, rows + 1, cols - 1)) {
            if (matrix[rows + 1][cols - 1].equals("q")) {
                return false;
            }
            cols--;
            rows++;
        }

        rows = initialRowIndex;
        cols = initialColIndex;
        while (isInBounds(matrix, rows - 1, cols + 1)) {
            if (matrix[rows - 1][cols + 1].equals("q")) {
                return false;
            }
            cols++;
            rows--;
        }

        return true;

    }

    private static boolean isInBounds(String[][] matrix, int rows, int cols) {
        return rows >= 0 && rows < matrix.length && cols >= 0 && cols < matrix[rows].length;
    }
}
