package setsAndMapsAdvanced.exercise;

import java.util.*;

public class P07HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Set<String>> personMap = new LinkedHashMap<>();
        while (!input.equals("JOKER")) {
            String[] inputArr = input.split(":");
            String name = inputArr[0];
            String[] cards = inputArr[1].trim().split(", ");

            personMap.putIfAbsent(name, new HashSet<>());
            personMap.get(name).addAll(Arrays.asList(cards));

            input = scanner.nextLine();
        }


        personMap.entrySet().forEach(entry -> {
            System.out.printf("%s: %d%n", entry.getKey(), getTotalValueOfCards(entry.getValue()) );
        });
    }

    private static int getTotalValueOfCards(Set<String> set) {
        int totalScore = 0;
        for (String card : set) {
            totalScore += cardScore(card);
        }
        return totalScore;
    }

    private static int cardScore(String card) {
        int score = 0;
        String substringPower = card.substring(0, card.length() -1);
        String substringType = card.substring(card.length() - 1);
        try {
            score = Integer.parseInt(substringPower);
        } catch (Exception e) {
            switch (substringPower) {
                case "J":
                    score = 11;
                    break;
                case "Q":
                    score = 12;
                    break;
                case "K":
                    score = 13;
                    break;
                case "A":
                    score = 14;
                    break;
            }

        }
        score *= cardType(substringType);
        return score;
    }

    private static int cardType(String substringType) {
        int type = 0;
        switch (substringType) {
            case "S":
                type = 4;
                break;
            case "H":
                type = 3;
                break;
            case "D":
                type = 2;
                break;
            case "C":
                type = 1;
                break;
        }
        return type;
    }
}
