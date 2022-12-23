package stackAndQueue.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P08BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String urlAddress = scanner.nextLine();

        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> stackFw = new ArrayDeque<>();

        String lastAddress;
        while (!urlAddress.equals("Home")) {
            if (urlAddress.equals("back")) {
                if (stack.size() > 1) {
                    lastAddress = stack.pop();
                    urlAddress = stack.peek();

                    stackFw.push(lastAddress);

                } else {
                    System.out.println("no previous URLs");
                    urlAddress = scanner.nextLine();
                    continue;
                }

            } else if (urlAddress.equals("forward")) {
                if (stackFw.size() > 0) {
                    urlAddress = stackFw.pop();
                    stack.push(urlAddress);

                } else {
                    System.out.println("no next URLs");
                    urlAddress = scanner.nextLine();
                    continue;
                }
            } else {
                stackFw.clear();
                stack.push(urlAddress);
            }

            System.out.println(urlAddress);


            urlAddress = scanner.nextLine();
        }
    }
}
