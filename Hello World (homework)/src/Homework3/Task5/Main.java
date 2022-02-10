package Homework3.Task5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String text = "Миссис Тленимрак - пессимист";
        int counter = 0;
        Pattern pattern = Pattern.compile("\\b(.*с.*){3,}\\b", Pattern.CASE_INSENSITIVE);
        String[] splitStringIntoWords = text.split(" ");
        for (String s : splitStringIntoWords) {
            Matcher matcher = pattern.matcher(s);
            while (matcher.find()) {
                counter++;
            }
        }
        System.out.println("Количество слов с 3-мя и более буквами \"с\" - " + counter);
    }
}
