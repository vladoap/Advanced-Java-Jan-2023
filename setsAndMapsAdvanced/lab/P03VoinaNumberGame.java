package setsAndMapsAdvanced.lab;

import javax.swing.text.html.HTMLDocument;
import java.util.*;
import java.util.stream.Collectors;

public class P03VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> playerOneDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> playerTwoDeck = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int rounds = 50;

        while (rounds-- > 0) {
            int firstNumber = playerOneDeck.iterator().next();
            playerOneDeck.remove(firstNumber);

            int secondNumber = playerTwoDeck.iterator().next();
            playerTwoDeck.remove(secondNumber);

            if (firstNumber > secondNumber) {
                playerOneDeck.add(firstNumber);
                playerOneDeck.add(secondNumber);
            } else if (secondNumber > firstNumber) {
                playerTwoDeck.add(firstNumber);
                playerTwoDeck.add(secondNumber);
            }

            if (playerOneDeck.isEmpty() || playerTwoDeck.isEmpty()) {
                break;
            }

        }

        if (playerTwoDeck.isEmpty() || playerOneDeck.size() > playerTwoDeck.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Second player win!");
        }

    }
}
