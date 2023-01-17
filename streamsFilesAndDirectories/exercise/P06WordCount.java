package streamsFilesAndDirectories.exercise;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class P06WordCount {
    public static void main(String[] args) throws IOException {

        BufferedReader file = new BufferedReader(new FileReader("resourcesExercise/words.txt"));
        Map<String, Integer> wordsMap = new HashMap<>();
        List<String> initialWords = new ArrayList<>();
        String line = file.readLine();
        while (line != null) {
            String[] wordsLine = line.split("\\s+");
            for (String s : wordsLine) {
                if (wordsMap.putIfAbsent(s, 0) == null) {
                    initialWords.add(s);
                };
            }

            line = file.readLine();
        }

        BufferedReader text = new BufferedReader(new FileReader("resourcesExercise/text.txt"));

        String lineText = text.readLine();
        while (lineText != null) {
            List<String> wordsList = Arrays.stream(lineText.split("\\s+")).collect(Collectors.toList());

            for (String word : wordsList) {
                if (wordsMap.containsKey(word)) {
                    int currentValue = wordsMap.get(word);
                    wordsMap.put(word, currentValue + 1);
                }
            }
            lineText = text.readLine();
        }

        PrintWriter printer = new PrintWriter(new FileWriter("resourcesExercise/result.txt"));

        wordsMap.entrySet().stream().sorted((l,r) -> r.getValue().compareTo(l.getValue()))
                .forEach(entry -> printer.println(String.format("%s - %d", entry.getKey(), entry.getValue())));


        printer.close();
        file.close();
        text.close();
    }
}
