package Homework5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task8 {

    private static final File INPUT_FILE_ONE = new File("/Users/lizafomichenok/Documents/Разработка/INPUTFILE.txt");
    private static final File INPUT_FILE_TWO = new File("/Users/lizafomichenok/Documents/Разработка/INPUTFILE2.txt");
    private static final File OUTPUT_FILE = new File("/Users/lizafomichenok/Documents/Разработка/OUTPUTFILE.txt");
    private static final List<String> fileLineByLine = new ArrayList<>();

    public static void main(String[] args) {
        String lineOne;
        String lineTwo;
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(INPUT_FILE_ONE)));
             BufferedReader reader2 = new BufferedReader(
                     new InputStreamReader(
                             new FileInputStream(INPUT_FILE_TWO)));
             FileWriter fileWriter = new FileWriter(OUTPUT_FILE)) {

            while ((lineOne = reader.readLine()) != null) {
                fileLineByLine.add(lineOne);
            }

            while ((lineTwo = reader2.readLine()) != null) {
                for (String s : fileLineByLine) {
                    if (lineTwo.equals(s)) {
                        fileWriter.write(lineTwo + "\n");
                        break;
                    }
                }
            }

        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("file not found");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
