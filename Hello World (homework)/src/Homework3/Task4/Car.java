package Homework3.Task4;

import java.util.Arrays;

public class Car {
    private final String carBrand;
    private String carColor;

    public String getCarBrand() {
        return carBrand;
    }

    public String getCarColor() {
        return carColor;
    }

    private void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public Car(String carBrand, String carColor) {
        if ((carBrand.equalsIgnoreCase(CarBrands.AUDI.name) & Arrays.asList(CarBrands.audiColors).contains(carColor.toLowerCase()))
                | (carBrand.equalsIgnoreCase(CarBrands.BMW.name) & Arrays.asList(CarBrands.bmwColors).contains(carColor.toLowerCase()))
                | (carBrand.equalsIgnoreCase(CarBrands.KIA.name) & Arrays.asList(CarBrands.kiaColors).contains(carColor.toLowerCase()))) {
            this.carBrand = carBrand;
            this.carColor = carColor;
            } else {
            throw new IllegalArgumentException("Нет такой марки или цвета");
        }
    }

    public void changeCarColor(String color) {
        if ((carBrand.equalsIgnoreCase(CarBrands.AUDI.name) & Arrays.asList(CarBrands.audiColors).contains(color.toLowerCase()))
                | (carBrand.equalsIgnoreCase(CarBrands.BMW.name) & Arrays.asList(CarBrands.bmwColors).contains(color.toLowerCase()))
                | (carBrand.equalsIgnoreCase(CarBrands.KIA.name) & Arrays.asList(CarBrands.kiaColors).contains(color.toLowerCase()))) {
            setCarColor(color);
            System.out.println("Машина перекрашена в " + color.toLowerCase() + " цвет");
        } else {
            System.out.println("Машина не перекрашена");
        }
    }
}
