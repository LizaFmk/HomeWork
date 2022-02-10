package Homework3.Task8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String text = "Payment successful. Card number: 1111-2222-3333-4444. Cardholder: IVAN IVANOV";
        String cardNumber = "";
        Pattern pattern = Pattern.compile("\\D\\d{4}-\\d{4}-\\d{4}-\\d{4}\\D");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            cardNumber = matcher.group();
        }
        System.out.println(cardNumber);
    }
}
