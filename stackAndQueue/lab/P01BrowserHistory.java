package stackAndQueue.lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String urlAddress = scanner.nextLine();

        ArrayDeque<String> stack = new ArrayDeque<>();
        String lastAddress;
        while (!urlAddress.equals("Home")) {
            if (urlAddress.equals("back")) {
                if (stack.size() > 1) {
                    stack.pop();
                    urlAddress = stack.peek();
                } else {
                    System.out.println("no previous URLs");
                    urlAddress = scanner.nextLine();
                    continue;
                }

            } else {
                stack.push(urlAddress);
            }

            System.out.println(urlAddress);


            urlAddress = scanner.nextLine();
        }
    }
}
