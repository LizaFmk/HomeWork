package Homework5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task7 {

    private static List<String> tmp = new ArrayList<>();
    private static final File INPUT_FILE = new File("/Users/lizafomichenok/Documents/Разработка/INPUTFILE.txt");
    private static final File OUTPUT_FILE = new File("/Users/lizafomichenok/Documents/Разработка/OUTPUTFILE.txt");

    public static void main(String[] args) {
        String line;
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(INPUT_FILE)));
             FileWriter fileWriter = new FileWriter(OUTPUT_FILE)) {

            while ((line = reader.readLine()) != null) {
                tmp.add(line);
            }
            for (int i = tmp.size() - 1; i > -1; i--) {
                fileWriter.write(tmp.get(i) + "\n");
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
