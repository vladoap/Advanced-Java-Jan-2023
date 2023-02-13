package iteratorsAndComparators.stackIterator;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] commandArr = scanner.nextLine().split("\\s+");
        int[] elementsToPush = new int[commandArr.length - 1];
        for (int i = 0; i < commandArr.length - 1; i++) {
            int element = Integer.parseInt(String.valueOf(commandArr[i + 1].charAt(0)));
            elementsToPush[i] = element;
        }


        customStack stack = new customStack(elementsToPush);

        String command = scanner.nextLine();

        while (!command.equals("END")) {
            if (command.contains("Pop")) {
                stack.pop();
            }

            command = scanner.nextLine();
        }

        for (Integer element : stack) {
            System.out.println(element);
        }
        for (Integer element : stack) {
            System.out.println(element);
        }
    }
}
