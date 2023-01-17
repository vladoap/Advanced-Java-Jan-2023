package setsAndMapsAdvanced.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P08UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Map<String, Integer>> userMap = new TreeMap<>();
        while (!input.equals("end")) {
            String ip = input.split("\\s+")[0].substring(3);
            String user = input.split("user=")[1];

            userMap.putIfAbsent(user, new LinkedHashMap<>());
            userMap.get(user).putIfAbsent(ip, 0);
            int currentOccurrenceIP = userMap.get(user).get(ip);
            userMap.get(user).put(ip, currentOccurrenceIP + 1);


            input = scanner.nextLine();
        }

        for (var entry : userMap.entrySet()) {
            System.out.printf("%s:%n", entry.getKey());

            StringBuilder sb = new StringBuilder();
            for (var innerEntry : entry.getValue().entrySet()) {
                sb.append(String.format("%s => %d,\n", innerEntry.getKey(), innerEntry.getValue()));
            }
            String finalOutput = sb.substring(0, sb.length() - 2);
            System.out.println(finalOutput + ".");


        }

    }
}
