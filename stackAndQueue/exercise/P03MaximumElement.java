package stackAndQueue.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countCommands = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < countCommands ; i++) {
            int[] commandArr = Arrays
                    .stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            switch (commandArr[0]) {
                case 1:
                    stack.push(commandArr[1]);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    int maxNumber = stack.stream().mapToInt(e -> e).max().getAsInt();
                    System.out.println(maxNumber);
                    break;
            }

        }
    }
}
