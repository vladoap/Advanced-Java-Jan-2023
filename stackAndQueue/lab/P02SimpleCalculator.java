package stackAndQueue.lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(n -> queue.offer(n));

        int sum = 0;
        String operator = null;
        while (!queue.isEmpty()) {
            String symbol = queue.pop();
            if (symbol.equals("+")) {
                operator = symbol;
            } else if (symbol.equals("-")) {
                operator = symbol;
            } else {
                int number = Integer.parseInt(symbol);
                if (operator == null) {
                    sum = number;
                } else if (operator.equals("+")){
                    sum += number;
                } else if (operator.equals("-")) {
                    sum -= number;
                }
            }

        }
        System.out.println(sum);

    }
}
