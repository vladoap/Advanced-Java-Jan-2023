package multidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];
        for (int rows = 0; rows < matrix.length; rows++) {
            int[] arr= Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int cols = 0; cols < matrix[rows].length; cols++) {
                matrix[rows][cols] = arr[cols];
            }
        }
        int rows = 0;
        int cols = 0;
        while (rows < matrix.length && cols < matrix[rows].length ) {
            System.out.print(matrix[rows][cols] + " ");
            cols++;
            rows++;
        }
        System.out.println();
        rows = matrix.length - 1;
        cols = 0;
        while (rows >= 0 && cols < matrix[rows].length ) {
            System.out.print(matrix[rows][cols] + " ");
            cols++;
            rows--;
        }


    }


        }

