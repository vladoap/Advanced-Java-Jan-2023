package multidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = getArrayInt(scanner);

        int arraysCount = dimensions[0];
        int sizeOfArray = dimensions[1];

        int[][] firstMatrix = new int[arraysCount][sizeOfArray];

        for (int rows = 0; rows < firstMatrix.length; rows++) {
            int[] arr = getArrayInt(scanner);
            for (int cols = 0; cols < arr.length; cols++) {
                firstMatrix[rows][cols] = arr[cols];
            }
        }

        dimensions = getArrayInt(scanner);
        arraysCount = dimensions[0];
        sizeOfArray = dimensions[1];
        int[][] secondMatrix = new int[arraysCount][sizeOfArray];

        for (int rows = 0; rows < secondMatrix.length; rows++) {
            int[] arr = getArrayInt(scanner);
            for (int cols = 0; cols < arr.length; cols++) {
                secondMatrix[rows][cols] = arr[cols];
            }
        }

        String result = isEqual(firstMatrix, secondMatrix)
                ? "equal"
                : "not equal";


        System.out.println(result);

    }

    private static int[] getArrayInt(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static boolean isEqual(int[][] first, int[][] second) {
        if (first.length != second.length) {
            return false;
        }
        for (int r = 0; r < first.length; r++) {
            if (first[r].length != second[r].length) {
                return false;
            }
            for (int c = 0; c < first[r].length; c++) {
                if (first[r][c] != second[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }
}
