package Homework5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        String value;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (!(value = reader.readLine()).equalsIgnoreCase("stop")) {
                list.add(Integer.parseInt(value));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(list);
        System.out.println(list);
    }
}
