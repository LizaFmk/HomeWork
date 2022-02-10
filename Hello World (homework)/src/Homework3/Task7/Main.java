package Homework3.Task7;

import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String text = "Астра акация ананас апельсин клубника абракадабра";
        String[] splitStringIntoWords = text.split(" ");

        for (int i = 0; i < splitStringIntoWords.length; i++) {
            splitStringIntoWords[i] = splitStringIntoWords[i].replaceAll("\\p{Punct}|\\d", "");
            if (Pattern.matches("[Аа].*[Аа]", splitStringIntoWords[i])) {
                System.out.println(splitStringIntoWords[i]);
            }
        }
    }
}
