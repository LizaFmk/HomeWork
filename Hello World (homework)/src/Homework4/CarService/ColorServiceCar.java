package Homework4.CarService;

import Homework4.Car.Car;
import Homework4.Enums.ColorsCar;

public class ColorServiceCar implements ServiceCar<ColorsCar> {
    @Override
    public Car change(Car car, ColorsCar color) {
        car.setColor(color);
        return car;
    }
}
