package stackAndQueue.lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P06HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(n -> queue.offer(n));
        int n = Integer.parseInt(scanner.nextLine());


        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                String firstChild = queue.poll();
                queue.offer(firstChild);
            }
            System.out.println("Removed " + queue.poll());

        }
        System.out.println("Last is " + queue.peek());
    }
}
