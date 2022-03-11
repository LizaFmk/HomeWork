package Homework6;

public enum PartsOfRobot {
    HEAD ("Голова", 0),
    BODY("Тело", 1),
    RIGHT_HAND("Правая рука", 2),
    LEFT_HAND("Левая рука", 3),
    RIGHT_LEG("Правая нога", 4),
    LEFT_LEG("Левая нога", 5);

    private String name;
    private int index;

    PartsOfRobot(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }
}
