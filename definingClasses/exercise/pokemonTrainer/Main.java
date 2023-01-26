package definingClasses.exercise.pokemonTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Trainer> trainers = new ArrayList<>();
        String line = scanner.nextLine();


        while (!line.equals("Tournament")) {
            String[] data = line.split("\\s+");
            String trainerName = data[0];
            String pokemonName = data[1];
            String pokemonElement = data[2];
            int pokemonHealth = Integer.parseInt(data[3]);

            boolean trainerExists = trainers.stream().anyMatch(tr -> tr.getName().equals(trainerName));
           if (!trainerExists) {
               Trainer trainer = new Trainer(trainerName);
               trainers.add(trainer);
           }

           Trainer currentTrainer = trainers.stream().filter(tr -> tr.getName().equals(trainerName)).findFirst().get();
           currentTrainer.getPokemons()
                   .add(new Pokemon(pokemonName, pokemonElement, pokemonHealth));

            line = scanner.nextLine();
        }

        line = scanner.nextLine();

        while (!line.equals("End")) {
            String element = line;
            trainers.forEach(tr -> tr.checkElement(element));

            line = scanner.nextLine();
        }

        trainers.stream().sorted((f,s) -> Integer.compare(s.getNumberOfBadges(), f.getNumberOfBadges()))
                .forEach(System.out::println);

        }
    }

