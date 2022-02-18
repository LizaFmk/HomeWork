package Homework4;

public enum Colors {
    RED("Красный"),
    WHITE("Белый"),
    BLACK("Чёрный"),
    SILVER("Серебристый"),
    ;

    private String name;

    Colors(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
