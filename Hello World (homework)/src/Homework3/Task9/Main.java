package Homework3.Task9;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String text = "В Китае разработали экспресс-тест, выявляющий коронавирус за 4 минуты.";
        Matcher matcher = Pattern.compile("коронавирус", Pattern.CASE_INSENSITIVE).matcher(text);
        if (matcher.find()) {
            System.out.println(matcher.start());
        }
    }
}
