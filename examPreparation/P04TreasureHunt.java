package examPreparation;


import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;

public class P04TreasureHunt {
    static int playerRow = -1;
    static int playerCol = -1;
    static List<String> correctDirections = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        Character[][] field = new Character[rows][cols];

        for (int row = 0; row < rows ; row++) {
            Character[] singleRow = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(e -> e.charAt(0))
                    .toArray(Character[]::new);

            for (int col = 0; col < cols; col++) {
                if (col < singleRow.length) {
                    field[row][col] = singleRow[col];
                } else {
                    field[row][col] = '-';
                }
                if (field[row][col] == 'Y') {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("Finish")) {

            switch (command) {
                case "up":
                    playerMove(field, command, -1, 0);
                    break;
                case "down":
                    playerMove(field, command, 1, 0);
                    break;
                case "left":
                    playerMove(field, command, 0, -1);
                    break;
                case "right":
                    playerMove(field, command, 0, 1);
                    break;
            }

            command = scanner.nextLine();
        }

        if (field[playerRow][playerCol] == 'X') {
            System.out.println("I've found the treasure!");
            System.out.println(String.format("The right path is %s", String.join(", ", correctDirections)));
        } else {
            System.out.println("The map is fake!");
        }
    }

    private static void playerMove(Character[][] field, String command, int r, int c) {
        int nextRow = playerRow + r;
        int nextCol = playerCol + c;

        if (isInBounds(field, nextRow, nextCol)) {
            if (field[nextRow][nextCol] != 'T') {
                playerRow = nextRow;
                playerCol = nextCol;
                correctDirections.add(command);
            }
        }
    }

    private static boolean isInBounds(Character[][] field, int r, int c) {
        return r >= 0 && r < field.length && c >= 0 && c < field[r].length;
    }
}
