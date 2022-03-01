package Homework5.Task9and10;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Serialization {
    public static void serializeListOfObject(List<?> list, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(fileName))) {
            for (Object o : list) {
                oos.writeObject(o);
            }
            oos.writeObject(list);
        } catch (IOException e) {
            System.err.println(e.getMessage() + Arrays.toString(e.getStackTrace()));
        }
    }

    public static <T> List<T> deserilizeObjectFromFile(String fileName) {
        List<T> list = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(fileName))) {
            int i = 0;
            while (i++ < 5) {
                list.add((T) ois.readObject());
            }
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println(e.getMessage() + Arrays.toString(e.getStackTrace()));
        }
        return list;
    }
}
