package multidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int arraysCount = dimensions[0];
        int sizeOfArray = dimensions[1];
        int[][] matrix = new int[arraysCount][sizeOfArray];
        int sum = 0;
        for (int rows = 0; rows < matrix.length; rows++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                matrix[rows][cols] = arr[cols];
                sum += arr[cols];
            }
        }

        System.out.println(arraysCount);
        System.out.println(sizeOfArray);
        System.out.println(sum);

    }
}
