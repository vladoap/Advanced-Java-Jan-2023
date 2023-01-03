package multidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arraysCount = Integer.parseInt(scanner.nextLine());
        int sizeOfArray = Integer.parseInt(scanner.nextLine());
        String[][] firstMatrix = new String[arraysCount][sizeOfArray];
        String[][] secondMatrix = new String[arraysCount][sizeOfArray];

        for (int rows = 0; rows < firstMatrix.length; rows++) {
            String[] arr = scanner.nextLine().split("\\s+");
            for (int cols = 0; cols < firstMatrix[rows].length; cols++) {
                firstMatrix[rows][cols] = arr[cols];
            }
        }

        for (int rows = 0; rows < secondMatrix.length; rows++) {
            String[] arr = scanner.nextLine().split("\\s+");
            for (int cols = 0; cols < secondMatrix[rows].length; cols++) {
                secondMatrix[rows][cols] = arr[cols];
            }
        }

        for (int rows = 0; rows < firstMatrix.length; rows++) {
            for (int cols = 0; cols < firstMatrix[rows].length; cols++) {
               if (!firstMatrix[rows][cols].equals(secondMatrix[rows][cols])) {
                   System.out.print("* ");
               } else {
                   System.out.print(firstMatrix[rows][cols] + " ");
               }

            }
            System.out.println();
        }



    }
}
