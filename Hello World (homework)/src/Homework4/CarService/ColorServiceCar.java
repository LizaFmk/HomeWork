package Homework4.CarService;

import Homework4.Car.Car;
import Homework4.Enums.ColorsCar;

public class ColorServiceCar implements ServiceCar {

    @Override
    public <T extends Car> Car change(T car, Enum color) {
        car.setColor((ColorsCar) color);
        return car;
    }
}
