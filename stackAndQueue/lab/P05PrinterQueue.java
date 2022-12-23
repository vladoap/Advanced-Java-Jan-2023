package stackAndQueue.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> queue = new ArrayDeque<>();
        while (!input.equals("print")) {
            if (input.equals("cancel")) {
                String fileName = queue.isEmpty()
                        ? "Printer is on standby"
                        : "Canceled " + queue.poll();
                System.out.println(fileName);
            }   else {
                queue.offer(input);
            }

            input = scanner.nextLine();
        }

        for (String element : queue) {
            System.out.println(element);
        }
    }
}
