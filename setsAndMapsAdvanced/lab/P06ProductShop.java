package setsAndMapsAdvanced.lab;

import java.util.*;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, LinkedHashMap<String, Double>> foodShopsMap = new TreeMap<>();
        String input = scanner.nextLine();

        while (!input.equals("Revision")) {
            String[] inputArr = input.split(", ");
            String shop = inputArr[0];
            String product = inputArr[1];
            double price = Double.parseDouble(inputArr[2]);
            foodShopsMap.putIfAbsent(shop, new LinkedHashMap<>());
            foodShopsMap.get(shop).put(product, price);

            input = scanner.nextLine();
        }

        foodShopsMap.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + "->");
            entry.getValue().entrySet().forEach(innerEntry -> {
                System.out.printf("Product: %s, Price: %.1f%n", innerEntry.getKey(), innerEntry.getValue());
            });
        });
    }
}
