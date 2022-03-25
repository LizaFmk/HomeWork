package Homework4.CarService;

import Homework4.Car.Car;
import Homework4.Enums.EnumsCar;

public interface ServiceCar<E extends EnumsCar> {
    Car change(Car car, E e);
}
