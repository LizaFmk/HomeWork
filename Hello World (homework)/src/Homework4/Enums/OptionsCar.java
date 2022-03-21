package Homework4.Enums;

public enum OptionsCar {
    BLUETOOTH("Bluetooth"),
    PARKTRONIC("Парктроники"),
    STEREOSYSTEM("Стереосистема"),
    ;

    private String name;

    OptionsCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
