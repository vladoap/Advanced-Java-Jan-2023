package examPreparation;

import java.util.Scanner;

public class P02Snake {
    static int snakeRow = -1;
    static int snakeCol = -1;
    static boolean outOfBounds = false;
    static int foodQuantity = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        char[][] territory = new char[n][n];

        for (int i = 0; i < territory.length; i++) {
            char[] singleRow = scanner.nextLine().toCharArray();
            for (int j = 0; j < territory[i].length; j++) {
                territory[i][j] = singleRow[j];
                if (territory[i][j] == 'S') {
                    snakeRow = i;
                    snakeCol = j;
                }
            }
        }

        String direction = scanner.nextLine();


        while (!outOfBounds && foodQuantity < 10) {
            switch (direction) {
                case "left":
                    snakeMove(territory, 0, -1);
                    break;
                case "right":
                    snakeMove(territory, 0, 1);
                    break;
                case "up":
                    snakeMove(territory, -1, 0);
                    break;
                case "down":
                    snakeMove(territory, 1, 0);
                    break;
            }
            if (foodQuantity >= 10 || outOfBounds) {
                break;
            }
            direction = scanner.nextLine();
        }

       if (outOfBounds) {
           System.out.println("Game over!");
       } else if (foodQuantity >= 10) {
           System.out.println("You won! You fed the snake.");
       }
        System.out.println("Food eaten: " + foodQuantity);

        for (char[] rows : territory) {
            for (char cols : rows) {
                System.out.print(cols);
            }
            System.out.println();
        }

    }

    private static void snakeMove(char[][] territory, int rowMutator, int colMutator) {
        int nextRow = snakeRow + rowMutator;
        int nextCol = snakeCol + colMutator;
        territory[snakeRow][snakeCol] = '.';

        if (isInBounds(territory, nextRow, nextCol)) {
            if (territory[nextRow][nextCol] == '-') {
                territory[nextRow][nextCol] = 'S';
                snakeRow = nextRow;
                snakeCol = nextCol;
            } else if (territory[nextRow][nextCol] == '*') {
                territory[nextRow][nextCol] = 'S';
                snakeRow = nextRow;
                snakeCol = nextCol;
                foodQuantity++;
            } else if (territory[nextRow][nextCol] == 'B') {
                territory[nextRow][nextCol] = '.';

                for (int rows = 0; rows < territory.length; rows++) {
                    for (int cols = 0; cols < territory[rows].length; cols++) {
                        if (territory[rows][cols] == 'B') {
                            territory[rows][cols] = 'S';
                            snakeRow = rows;
                            snakeCol = cols;
                            break;
                        }
                    }
                }

            }

        } else {
            outOfBounds = true;
        }

    }

    private static boolean isInBounds(char[][] territory, int r, int c) {
        return r >= 0 && r < territory.length && c >= 0 && c < territory[r].length;
    }
}
