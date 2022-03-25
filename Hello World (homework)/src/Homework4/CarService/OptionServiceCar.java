package Homework4.CarService;

import Homework4.Car.Car;
import Homework4.Enums.EnumsCar;
import Homework4.Enums.OptionsCar;

import java.util.Set;

public class OptionServiceCar implements ServiceCar<OptionsCar> {

    @Override
    public Car change(Car car, OptionsCar option) {
        if (car.getOptions().contains(option)) {
            car.deteleOption(option);
        } else {
            car.addOption(option);
        }
        return car;
    }

    public <T extends Car> Car deleteAllOptions(T car) {
        car.deleteAllOptions();
        return car;
    }

    public <T extends Car> Car setOptions(T car, Set<OptionsCar> options) {
        car.setOptions(options);
        return car;
    }
}
