package setsAndMapsAdvanced.exercise;

import java.util.*;

public class P10LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Set<String>> usersIpAndDuration = new TreeMap<>();
        Map<String, Integer> usersDuration = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputArr = scanner.nextLine().split("\\s+");
            String ip = inputArr[0];
            String user = inputArr[1];
            int duration = Integer.parseInt(inputArr[2]);
            if (!usersIpAndDuration.containsKey(user)) {
                usersIpAndDuration.put(user, new TreeSet<>());
                usersIpAndDuration.get(user).add(ip);
                usersDuration.put(user, 0);
            }

            Set<String> ips = usersIpAndDuration.get(user);
            ips.add(ip);
            usersDuration.put(user, usersDuration.get(user) + duration);

        }

        usersIpAndDuration.entrySet().forEach(user -> {
            System.out.printf("%s: %d ", user.getKey(), usersDuration.get(user.getKey()));
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            user.getValue().forEach(ip -> {
                         sb
                        .append(ip)
                        .append(", ");
            });
            String output = sb.substring(0, sb.length() - 2);
            System.out.println(output + "]");
        });
    }
}
