package Homework3.Task2and10;

import java.util.regex.Pattern;

public class Box {
    private final int height;
    private final int length;
    private final int width;

    public Box(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public Box(int length, int width) {
        this.height = 0;
        this.length = length;
        this.width = width;
    }

    public Box(int allParameters) {
        this.height = allParameters;
        this.length = allParameters;
        this.width = allParameters;
    }

    public Box(String parameters) {
        if (Pattern.matches("Box\\[\\d\\]", parameters)) {
            parameters = parameters.replaceAll("\\D", "");
            this.height = Integer.parseInt(parameters);
            this.length = height;
            this.width = length;
        } else if (Pattern.matches("Box\\[\\d,\\s\\d\\]", parameters)) {
            String[] arr = parameters.split(" ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i].replaceAll("\\D", "");
            }
            this.width = Integer.parseInt(arr[0]);
            this.length = Integer.parseInt(arr[1]);
            this.height = 0;
        } else if (Pattern.matches("Box\\[\\d,\\s\\d\\,\\s\\d]", parameters)) {
            String[] arr = parameters.split(" ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i].replaceAll("\\D", "");
            }
            this.width = Integer.parseInt(arr[0]);
            this.length = Integer.parseInt(arr[1]);
            this.height = Integer.parseInt(arr[2]);
        } else {
            throw new IllegalArgumentException("Некорректный аргумент");
        }
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public String checkTypeOfBox() {
        if (this.height == 0) {
            if (this.width == 0 | this.length == 0) {
                return "Воображаемая коробка";
            } else {
                return "Конверт";
            }
        } else if (this.length == this.height & this.height == this.width) {
            return "Куб";
        } else {
            return "Обычная коробка";
        }
    }
}
