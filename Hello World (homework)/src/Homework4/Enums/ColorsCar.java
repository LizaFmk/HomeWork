package Homework4.Enums;

public enum ColorsCar {
    RED("Красный"),
    WHITE("Белый"),
    BLACK("Чёрный"),
    SILVER("Серебристый"),
    ;

    private String name;

    ColorsCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
