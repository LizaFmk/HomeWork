package Homework5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task3 {
    public static void main(String[] args) {
        Integer sum = 0;
        Integer counter = 0;
        String value;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (!(value = reader.readLine()).equalsIgnoreCase("stop")) {
                sum += Integer.parseInt(value);
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sum/counter);
    }
}
