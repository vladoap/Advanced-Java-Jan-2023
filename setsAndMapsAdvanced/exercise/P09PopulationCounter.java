package setsAndMapsAdvanced.exercise;

import java.util.*;
import java.util.stream.Collectors;

public class P09PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Long>> countriesAndCities = new LinkedHashMap<>();
        Map<String, Long> countriesOnly = new LinkedHashMap<>();
        while (!input.equals("report")) {
            String[] inputArr = input.split("\\|");
            String city = inputArr[0];
            String country = inputArr[1];
            long population = Long.parseLong(inputArr[2]);

            if (!countriesAndCities.containsKey(country)) {
                countriesAndCities.put(country, new LinkedHashMap<>());
                countriesOnly.put(country, 0L);
            }

            countriesOnly.put(country, countriesOnly.get(country) + population);
            if (!countriesAndCities.get(country).containsKey(city)) {
                countriesAndCities.get(country).put(city, population);
            }

            input = scanner.nextLine();
        }


        countriesAndCities.entrySet().stream()
                .sorted((c1,c2) -> countriesOnly.get(c2.getKey()).compareTo(countriesOnly.get(c1.getKey())))
                        .forEach(entry -> {
                            System.out.printf("%s (total population: %d)%n", entry.getKey(), countriesOnly.get(entry.getKey()));
                            entry.getValue().entrySet().stream()
                                    .sorted((t1,t2) -> t2.getValue().compareTo(t1.getValue()))
                                    .forEach(city -> {
                                        System.out.printf("=>%s: %d%n", city.getKey(), city.getValue());
                                    });


                        });


        }
    }

