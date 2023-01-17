package setsAndMapsAdvanced.lab;

import java.util.*;

public class P07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, List<String>>> cityMap = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] dataArr = scanner.nextLine().split("\\s+");
            String continent = dataArr[0];
            String country = dataArr[1];
            String city = dataArr[2];

            cityMap.putIfAbsent(continent, new LinkedHashMap<>());
            cityMap.get(continent).putIfAbsent(country, new ArrayList<>());
            cityMap.get(continent).get(country).add(city);

        }

        cityMap.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + ":");
            entry.getValue().entrySet().forEach(innerEntry -> {
                System.out.printf(" %s -> %s%n", innerEntry.getKey(), String.join(", ", innerEntry.getValue()));
            });
        });
    }
}
