package Homework4;

public enum Options {
    BLUETOOTH("Bluetooth"),
    PARKTRONIC("Парктроники"),
    STEREOSYSTEM("Стереосистема"),
    ;

    private String name;

    Options(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
