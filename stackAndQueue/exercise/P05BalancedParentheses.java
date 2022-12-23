package stackAndQueue.exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        boolean isBalanced = true;

        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (!stack.isEmpty()){
                char lastChar = stack.peek();
                switch (lastChar) {
                    case '{':
                        if (c == '}') {
                            stack.pop();
                        } else {
                            isBalanced = false;
                        }
                        break;
                    case '[':
                        if (c == ']') {
                            stack.pop();
                        } else {
                            isBalanced = false;
                        }
                        break;
                    case '(':
                        if (c == ')') {
                            stack.pop();
                        } else {
                            isBalanced = false;
                        }
                        break;
                }
            } else {
                isBalanced = false;
            }
            if (!isBalanced) {
                break;
            }

        }

        if (stack.isEmpty() && isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
