package Homework4.CarService;

import Homework4.Car.Car;

public interface ServiceCar {
    <T extends Car> Car change(T car, Enum e);
}
