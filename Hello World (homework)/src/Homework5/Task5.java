package Homework5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task5 {

    private static final char PLUS = '+';
    private static final char MINUS = '-';
    private static final char DIV = '/';
    private static final char MULT = '*';
    private static final String MESSAGE = "Результат вычисления: ";
    private static Integer numberOne = 0;
    private static Integer numberTwo = 0;
    private static Character operation = ' ';
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        System.out.println("Введите 2 числа:");
        numberOne = getNumber();
        numberTwo = getNumber();
        System.out.println("Введите операцию:");
        operation = getOperation();
        printResult();

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getNumber() {
        Integer number = 0;
        try {
            number = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException e) {
            System.err.println("Нужно ввести число");
            getNumber();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return number;
    }

    public static Character getOperation() {
        Character operation = ' ';
        try {
            operation = reader.readLine().charAt(0);
            switch (operation) {
                case PLUS:
                case MINUS:
                case DIV:
                case MULT: {
                    return operation;
                }
                default: {
                    System.out.println("Неверный оператор");
                    getOperation();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void printResult() {
        try {
            switch (operation) {
                case PLUS -> System.out.println(MESSAGE + (numberOne + numberTwo));
                case MINUS -> System.out.println(MESSAGE + (numberOne - numberTwo));
                case DIV -> System.out.println(MESSAGE + (numberOne / numberTwo));
                case MULT -> System.out.println(MESSAGE + (numberOne * numberTwo));
            }
        } catch (NullPointerException e) {
            System.err.println("Произошла ошибка. Попробуйте заново");
        }
    }
}
