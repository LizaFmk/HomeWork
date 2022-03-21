package Homework4.CarService;

import Homework4.Car.Car;
import Homework4.Car.MinibusCar;
import Homework4.Car.SportCar;
import Homework4.Car.TruckCar;
import Homework4.Enums.WheelSizesCar.WheelSizesMinibusCar;
import Homework4.Enums.WheelSizesCar.WheelSizesSportCar;
import Homework4.Enums.WheelSizesCar.WheelSizesTruckCar;

public class WheelServiceCar implements ServiceCar {

    @Override
    public <T extends Car> Car change(T car, Enum wheelSize) {
        if ((car instanceof MinibusCar & wheelSize instanceof WheelSizesMinibusCar)
            || (car instanceof SportCar & wheelSize instanceof WheelSizesSportCar)
            || (car instanceof TruckCar & wheelSize instanceof WheelSizesTruckCar)) {
            car.setWheelSize(wheelSize);
        } else {
            System.err.println("Неверный размер колёс");
        }
        return car;
    }
}
