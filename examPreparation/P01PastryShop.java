package examPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01PastryShop {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstLiquidQueue = new ArrayDeque<>();
        ArrayDeque<Integer> secondIngredientStack = new ArrayDeque<>();

       Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(firstLiquidQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(secondIngredientStack::push);

        int cookedBiscuits = 0;
        int cookedCakes = 0;
        int cookedPastry = 0;
        int cookedPie = 0;



        while (!firstLiquidQueue.isEmpty() && !secondIngredientStack.isEmpty()) {

            int liquidNumber = firstLiquidQueue.peek();
            int ingredientNumber = secondIngredientStack.peek();
            int sum = liquidNumber + ingredientNumber;
            boolean hasCooked = false;

            switch (sum) {
                case 25:
                    cookedBiscuits++;
                    hasCooked = true;
                    break;
                case 50:
                    cookedCakes++;
                    hasCooked = true;
                    break;
                case 75:
                    cookedPastry++;
                    hasCooked = true;
                    break;
                case 100:
                    cookedPie++;
                    hasCooked = true;
                    break;
            }

            if (hasCooked) {
                secondIngredientStack.pop();
            } else {
                int currentIngredient = secondIngredientStack.pop();
                secondIngredientStack.push(currentIngredient + 3);
            }

            firstLiquidQueue.poll();


        }
        if (cookedBiscuits > 0 && cookedCakes > 0 && cookedPastry > 0 && cookedPie > 0) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if (firstLiquidQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
           String output = firstLiquidQueue.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("Liquids left: %s%n", output);
        }

        if (secondIngredientStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            String output = secondIngredientStack.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("Ingredients left: %s%n", output);
        }
        System.out.println("Biscuit: " + cookedBiscuits);
        System.out.println("Cake: " + cookedCakes);
        System.out.println("Pie: " + cookedPie);
        System.out.println("Pastry: " + cookedPastry);


    }
}
