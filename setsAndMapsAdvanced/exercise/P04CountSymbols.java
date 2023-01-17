package setsAndMapsAdvanced.exercise;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Character, Integer> symbolsMap = new TreeMap<>();

        for (var symbol : input.toCharArray()) {
            symbolsMap.putIfAbsent(symbol, 0);
            int count = symbolsMap.get(symbol) + 1;
            symbolsMap.put(symbol,count);
        }

        symbolsMap.entrySet().forEach(entry -> {
            System.out.printf("%s: %d time/s%n", entry.getKey(), entry.getValue());
        });
    }
}
