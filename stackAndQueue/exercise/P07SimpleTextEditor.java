package stackAndQueue.exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOperations = Integer.parseInt(scanner.nextLine());
        StringBuilder sb = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < countOperations; i++) {
            String[] commandArr = scanner.nextLine().split("\\s+");
            int commandNum = Integer.parseInt(commandArr[0]);
            if (commandNum == 1) {
                String argument = commandArr[1];
                sb.append(argument);
                stack.push(sb.toString());
            } else if (commandNum == 2) {
                int elementsToErase = Integer.parseInt(commandArr[1]);
                int indexLastElement = sb.length();
                sb.replace(indexLastElement - elementsToErase, indexLastElement, "");
                stack.push(sb.toString());
            } else if (commandNum == 3) {
                int index = Integer.parseInt(commandArr[1]);
                char symbol = sb.charAt(index - 1);
                System.out.println(symbol);
            } else if (commandNum == 4) {

                stack.pop();
                if (stack.isEmpty()) {
                    sb = new StringBuilder();
                } else {
                    sb = new StringBuilder(stack.peek());
                }

            }
        }
    }
}
