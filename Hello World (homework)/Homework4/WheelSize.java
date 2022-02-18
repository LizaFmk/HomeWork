package Homework4;

public enum WheelSize {
    INCH16 ("16 дюймов"),
    INCH17("17 дюймов"),
    INCH18("18 дюймов"),
    ;

    private String name;

    WheelSize(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
