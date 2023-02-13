package examPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> effectsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> casingsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(effectsQueue::offer);

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(casingsStack::push);

        int countCherryBombs = 0;
        int countDaturaBombs = 0;
        int countSmokeBombs = 0;
        boolean isPouchFilled = false;
        while (!effectsQueue.isEmpty() && !casingsStack.isEmpty()) {
            int currentEffect = effectsQueue.peek();
            int currentCasing = casingsStack.peek();

            int sum = currentEffect + currentCasing;
            boolean hasCreated = false;
            if (sum == 40) {
                countDaturaBombs++;
                hasCreated = true;
            }else if (sum == 60) {
                countCherryBombs++;
                hasCreated = true;
            } else if (sum == 120) {
                countSmokeBombs++;
                hasCreated = true;
            }

            if (hasCreated) {
                effectsQueue.poll();
                casingsStack.pop();
            } else {
                int currentValue = casingsStack.pop();
                casingsStack.push(currentValue - 5);
            }


            if (countDaturaBombs >= 3 && countCherryBombs >= 3 && countSmokeBombs >= 3) {
                isPouchFilled = true;
                break;
            }
        }

        if (isPouchFilled) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (effectsQueue.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.println(String.format("Bomb Effects: %s", effectsQueue.stream().map(String::valueOf).collect(Collectors.joining(", "))));
        }

        if (casingsStack.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.println(String.format("Bomb Casings: %s", casingsStack.stream().map(String::valueOf).collect(Collectors.joining(", "))));
        }

        System.out.printf("Cherry Bombs: %d%n", countCherryBombs);
        System.out.printf("Datura Bombs: %d%n", countDaturaBombs);
        System.out.printf("Smoke Decoy Bombs: %d%n", countSmokeBombs);

    }
}
