package Homework3.Task2and10;

public class Main {
    public static void main(String[] args) {

        Box box = new Box("Box[2, 4, 5]");

        System.out.println(box.getWidth());
        System.out.println(box.getLength());
        System.out.println(box.getHeight());

        System.out.println(box.checkTypeOfBox());
    }
}
