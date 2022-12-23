package stackAndQueue.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09PoisonousPlants {
    public static boolean isDying = true;
    public static int countDyingDays = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countPlants = Integer.parseInt(scanner.nextLine());
        List<Integer> plantsList = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
         while (isDying) {
             plantsList = pesticideCalc(plantsList);

         }
        System.out.println(countDyingDays);


    }

    private static List<Integer> pesticideCalc(List<Integer> plantsList) {
        List<Integer> newPlantList = new ArrayList<>();
        newPlantList.add(plantsList.get(0));
        for (int i = 1; i < plantsList.size() ; i++) {
            if (plantsList.get(i) <= plantsList.get(i - 1)) {
                newPlantList.add(plantsList.get(i));
            }
        }
        if (plantsList.equals(newPlantList)) {
            isDying = false;
        } else {
            countDyingDays++;
        }

        return newPlantList;
    }

}
