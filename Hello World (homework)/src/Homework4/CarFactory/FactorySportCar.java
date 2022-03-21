package Homework4.CarFactory;

import Homework4.Car.Car;
import Homework4.Car.SportCar;
import Homework4.CarService.ColorServiceCar;
import Homework4.CarService.OptionServiceCar;
import Homework4.CarService.WheelServiceCar;
import Homework4.Enums.ColorsCar;
import Homework4.Enums.EngineCapacitiesCar.EngineCapacitiesSportCar;
import Homework4.Enums.ModelsCar.ModelsSportCar;
import Homework4.Enums.OptionsCar;
import Homework4.Enums.WheelSizesCar.WheelSizesSportCar;

import java.util.Set;

public class FactorySportCar extends FactoryCar {

    public FactorySportCar(WheelServiceCar wheelService, ColorServiceCar colorService, OptionServiceCar optionService) {
        super(wheelService, colorService, optionService);
        this.models = ModelsSportCar.values();
        this.engineCapacities = EngineCapacitiesSportCar.values();
        this.wheelSizes = WheelSizesSportCar.values();
    }
    public SportCar createCar(ColorsCar color,
                                ModelsSportCar model,
                                WheelSizesSportCar wheelSize,
                                EngineCapacitiesSportCar engineCapacity,
                                Set<OptionsCar> options) {
        Car car = searchNeededCar(color, model, wheelSize, engineCapacity, options);
        if (car != null) {
            StorageFactoryCar.get(model).remove(car);
            System.out.println("Машина доставлена со склада");
            return (SportCar) changeCarAccordingToOrder(car, color, wheelSize, options);
        } else {
            System.out.println("Подходящей машины на складе нет. Новая машина собрана");
            return new SportCar(color, model, wheelSize, engineCapacity, options);
        }
    }

    public SportCar createCar(ColorsCar color,
                              ModelsSportCar model,
                              WheelSizesSportCar wheelSize,
                              EngineCapacitiesSportCar engineCapacity) {
        Car car = searchNeededCar(color, model, wheelSize, engineCapacity, null);
        if (car != null) {
            StorageFactoryCar.get(model).remove(car);
            System.out.println("Машина доставлена со склада");
            return (SportCar) changeCarAccordingToOrder(car, color, wheelSize, null);
        } else {
            System.out.println("Подходящей машины на складе нет. Новая машина собрана");
            return new SportCar(color, model, wheelSize, engineCapacity);
        }
    }

    @Override
    protected SportCar createRandomCar() {
        return new SportCar(colors[RANDOM.nextInt(3)],
                ModelsSportCar.values()[RANDOM.nextInt(3)],
                WheelSizesSportCar.values()[RANDOM.nextInt(3)],
                EngineCapacitiesSportCar.values()[RANDOM.nextInt(2)]);
    }

}
