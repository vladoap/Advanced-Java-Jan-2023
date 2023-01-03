package multidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P02PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = getArrayInt(scanner);

        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = new int[rows][cols];

        for (int r = 0; r < matrix.length; r++) {
            int[] arr = getArrayInt(scanner);
            for (int c = 0; c < arr.length; c++) {
                matrix[r][c] = arr[c];
            }
        }
        int numberToFind = Integer.parseInt(scanner.nextLine());
        printIndexesOfNumber(matrix, numberToFind);

    }

    private static void printIndexesOfNumber(int[][] matrix, int numberToFind) {
        boolean isFound = false;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == numberToFind) {
                    System.out.println(r + " " + c);
                    isFound = true;
                }
            }
        }

        if (!isFound) {
            System.out.println("not found");
        }
    }

    private static int[] getArrayInt(Scanner scanner) {
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        return dimensions;
    }
}
