package streamsFilesAndDirectories.exercise;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class P04CountCharacterTypes {
    public static void main(String[] args) throws IOException {


        BufferedReader input = new BufferedReader(new FileReader("resourcesExercise/input.txt"));
        PrintWriter printer = new PrintWriter(new FileWriter("resourcesExercise/output.txt"));

        int symbol = input.read();
        int countVowels = 0;
        int countOtherSymbols = 0;
        int punctuation = 0;

        while (symbol >= 0) {

            if (isVowel(symbol)) {
                countVowels++;
            } else if (isPunctuation(symbol)) {
                punctuation++;
            } else if (!Character.isWhitespace(symbol)) {
                countOtherSymbols++;
            }

            symbol = input.read();
        }


        printer.println("Vowels: " + countVowels);
        printer.println("Other symbols: " + countOtherSymbols);
        printer.println("Punctuation: " + punctuation);

        input.close();
        printer.close();

    }

    private static boolean isPunctuation(int symbol) {
        switch (symbol) {
            case '!':
            case ',':
            case '.':
            case '?':
                return true;
        }
        return false;
    }

    private static boolean isVowel(int symbol) {
        switch (symbol) {
            case 'a':
            case 'e':
            case 'u':
            case 'i':
            case 'o':
                return true;
        }
        return false;
    }
}
