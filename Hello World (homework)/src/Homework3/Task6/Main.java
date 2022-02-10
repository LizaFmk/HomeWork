package Homework3.Task6;

public class Main {
    public static void main(String[] args) {
        String text = "Геомагнитная, буря!!! стала 12131242343543454656367647678 причиной- потери? 40 спутников// Starlink Илона@ Маска.";
        String[] splitStringIntoWords = text.split(" ");
        int longestWordLength = 0;

        for (int i = 0; i < splitStringIntoWords.length; i++) {
            splitStringIntoWords[i] = splitStringIntoWords[i].replaceAll("\\p{Punct}|\\d", "");
            if (splitStringIntoWords[i].length() > longestWordLength) {
                longestWordLength = splitStringIntoWords[i].length();
            }
        }

        // если длинных слов несколько

        for (String word : splitStringIntoWords) {
            if (word.length() == longestWordLength) {
                System.out.println(word);
            }
        }
    }
}
