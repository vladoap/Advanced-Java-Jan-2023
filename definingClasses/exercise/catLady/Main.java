package definingClasses.exercise.catLady;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Cat> cats = new HashMap();
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] data = input.split("\\s+");
            String breed = data[0];
            String name = data[1];
            double characteristicValue = Double.parseDouble(data[2]);

            switch (breed) {
                case "StreetExtraordinaire":
                    StreetExtraordinaire streetExtraordinaire = new StreetExtraordinaire(name, characteristicValue);
                    cats.put(name, streetExtraordinaire);
                    break;
                case "Siamese":
                    Siamse siamse = new Siamse(name, characteristicValue);
                    cats.put(name, siamse);
                    break;
                case "Cymric":
                    Cymric cymric = new Cymric(name, characteristicValue);
                    cats.put(name, cymric);
                    break;
            }
            input = scanner.nextLine();
        }
        String catNameToSearch = scanner.nextLine();

        if (cats.containsKey(catNameToSearch)) {
            Cat currentCat = cats.get(catNameToSearch);
            System.out.println(currentCat);
        }
    }
}
