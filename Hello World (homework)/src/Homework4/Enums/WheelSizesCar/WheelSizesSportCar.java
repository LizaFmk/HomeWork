package Homework4.Enums.WheelSizesCar;

public enum WheelSizesSportCar implements EnumsWheelSizesCar {
    INCH16 (16),
    INCH17(17),
    INCH18(18),
    ;

    private final Integer value;

    WheelSizesSportCar(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
