package Homework3.Task3;

public class Main {
    public static void main(String[] args) {
        Number.addNumber(10);
        Number.addNumber(2);
        Number.addNumber(14);
        Number.addNumber(126);
        Number.addNumber(5);
        Number.addNumber(25);
        Number.addNumber(33);
        Number.addNumber(8);

        System.out.println(Number.getFiveLastNumbers());
        Number.printAverage();
    }
}
