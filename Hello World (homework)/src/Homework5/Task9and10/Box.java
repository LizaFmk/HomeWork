package Homework5.Task9and10;

import java.io.Serializable;
import java.util.Random;

public class Box implements Serializable {

    private static final Random RANDOM = new Random(10);
    private final int height;
    private final int length;
    private final int width;

    public Box(int length, int width, int height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public static Box createBox() {
        return new Box(RANDOM.nextInt(), RANDOM.nextInt(), RANDOM.nextInt());
    }

    public int getVolume() {
        return height*length*width;
    }
}
