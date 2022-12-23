package stackAndQueue.exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(" ");
        ArrayDeque<String> stack = new ArrayDeque<>();

        Arrays.stream(numbers).forEach(e -> stack.push(e));
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
