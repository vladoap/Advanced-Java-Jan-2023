package stackAndQueue.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String lineInput = scanner.nextLine();
        ArrayDeque<Integer> stackIndices = new ArrayDeque<>();

        for (int i = 0; i < lineInput.length(); i++) {
            char symbol = lineInput.charAt(i);

            if (symbol == '(') {
              stackIndices.push(i);
            } else if (symbol == ')') {
                int startIndex = stackIndices.pop();
                int endIndex = i + 1;
                String substring = lineInput.substring(startIndex, endIndex);
                System.out.println(substring);
            }

        }

    }
}
