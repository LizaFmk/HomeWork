package Homework4.Enums.WheelSizesCar;

public enum WheelSizesMinibusCar {
    INCH16 (16),
    INCH17(17),
    INCH18(18),
    ;

    private final Integer value;

    WheelSizesMinibusCar(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
