package Homework3.Task1;

public enum Months {
    JANYARY("Январь", 1),
    FEBRYARY("Февраль", 2),
    MARCH("Март", 3),
    APRIL("Апрель", 4),
    MAY("Май", 5),
    JUNE("Июнь", 6),
    JULY("Июль", 7),
    AUGUST("Август", 8),
    SEPTEMBER("Сентябрь", 9),
    OCTOBER("Октябрь", 10),
    NOVEMBER("Ноябрь", 11),
    DECEMBER("Декабрь", 12);

    private final String name;
    private final int number;

    Months(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public static String findNameByNumber(int number) {
        for (Months value : values()) {
            if (value.number == number) {
                return value.name;
            }
        }
        return null;
    }

    public static int findNumberByName(String name) {
        for (Months value : values()) {
            if (value.name.equals(name)) {
                return value.number;
            }
        }
        return 0;
    }
}
