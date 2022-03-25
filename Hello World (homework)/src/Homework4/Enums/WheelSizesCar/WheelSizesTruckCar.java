package Homework4.Enums.WheelSizesCar;

public enum WheelSizesTruckCar implements EnumsWheelSizesCar {
    INCH60(60),
    INCH70(70),
    INCH80(80);

    private final Integer value;

    WheelSizesTruckCar(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
