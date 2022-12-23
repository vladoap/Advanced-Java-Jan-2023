package stackAndQueue.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split("\\s+");

        int countToPush = Integer.parseInt(inputArr[0]);
        int countToPop = Integer.parseInt(inputArr[1]);
        int numberToCheck = Integer.parseInt(inputArr[2]);
        boolean isExist = false;

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[] numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < countToPush; i++) {
            stack.push(numbers[i]);
        }

        for (int i = 0; i < countToPop; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println(0);
        } else {
            if (stack.contains(numberToCheck)) {
                System.out.println("true");
            } else {
                int minNumber = stack.stream().mapToInt(e -> e).min().getAsInt();
                System.out.println(minNumber);
            }
        }


    }
}
