package Homework5.Task9and10;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final List<Box> listOfBoxes = new ArrayList<>();
    private static final String fileName = "/Users/lizafomichenok/Documents/Разработка/OUTPUTFILE.txt";

    public static void main(String[] args) {
        while (listOfBoxes.size() < 5) {
            listOfBoxes.add(Box.createBox());
        }

        Serialization.serializeListOfObject(listOfBoxes, fileName);

        System.out.println(Serialization.deserilizeObjectFromFile(fileName));

    }
}
