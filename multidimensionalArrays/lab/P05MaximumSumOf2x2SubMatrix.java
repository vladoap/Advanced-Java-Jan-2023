package multidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P05MaximumSumOf2x2SubMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int arraysCount = dimensions[0];
        int sizeOfArray = dimensions[1];
        int[][] matrix = new int[arraysCount][sizeOfArray];
        for (int rows = 0; rows < matrix.length; rows++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                matrix[rows][cols] = arr[cols];

            }
        }
        int maxSum = Integer.MIN_VALUE;
        int[][] maxSumMatrix = new int[2][2];
        for (int r = 0; r < matrix.length - 1; r++) {
            for (int c = 0; c < matrix[r].length - 1; c++) {
                int[][] resultMatrix = new int[2][2];
                int currentSum = 0;
                resultMatrix[0][0] = matrix[r][c];
                resultMatrix[0][1] = matrix[r][c + 1];
                resultMatrix[1][0] = matrix[r + 1][c];
                resultMatrix[1][1] = matrix[r + 1][c + 1];
                for (int[] arr : resultMatrix) {
                    for (int num : arr) {
                        currentSum += num;
                    }
                }
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxSumMatrix = resultMatrix;
                }
            }
        }

        for (int[] arr : maxSumMatrix) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println(maxSum);
    }
    
}
