package setsAndMapsAdvanced.lab;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        DecimalFormat df = new DecimalFormat("0.####################################");
        Map<String, Double> scoresMap = new TreeMap<>();

        while (n-- > 0) {
            String name = scanner.nextLine();
            double[] scores = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble).toArray();

            double averageScore = 0;

            for (double score : scores) {
                averageScore += score;
            }
            averageScore /= scores.length;

            scoresMap.put(name, averageScore);



        }

        scoresMap.entrySet().forEach(entry -> {
            System.out.printf("%s is graduated with %s%n", entry.getKey(), df.format(entry.getValue()));
        });


    }
}
