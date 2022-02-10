package Homework3.Task3;

import java.util.ArrayList;

public class Number {
    private static final ArrayList<Integer> fiveLastNumbers = new ArrayList<>();
    private static int counter = 0;

    public static ArrayList<Integer> getFiveLastNumbers() {
        return fiveLastNumbers;
    }

    public static void addNumber(int number) {
        counter++;
        if (counter > 5) {
            fiveLastNumbers.remove(0);
        }
        fiveLastNumbers.add(number);
    }

    public static void printAverage() {
        double average = 0;
        for (int i = 0; i < 5; i++) {
            average += (double) fiveLastNumbers.get(i)/5;
        }
        System.out.println(average);
    }
}
