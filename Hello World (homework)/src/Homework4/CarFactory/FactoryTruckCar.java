package Homework4.CarFactory;

import Homework4.Car.Car;
import Homework4.Car.TruckCar;
import Homework4.CarService.ColorServiceCar;
import Homework4.CarService.OptionServiceCar;
import Homework4.CarService.WheelServiceCar;
import Homework4.Enums.EngineCapacitiesCar.EngineCapacitiesTruckCar;
import Homework4.Enums.ModelsCar.ModelsTruckCar;
import Homework4.Enums.WheelSizesCar.WheelSizesTruckCar;
import Homework4.Enums.ColorsCar;
import Homework4.Enums.OptionsCar;

import java.util.Set;

public class FactoryTruckCar extends FactoryCar {

    public FactoryTruckCar(WheelServiceCar wheelService, ColorServiceCar colorService, OptionServiceCar optionService) {
        super(wheelService, colorService, optionService);
        this.models = ModelsTruckCar.values();
        this.wheelSizes = WheelSizesTruckCar.values();
        this.engineCapacities = EngineCapacitiesTruckCar.values();
    }

    public TruckCar createCar(ColorsCar color,
                              ModelsTruckCar model,
                              WheelSizesTruckCar wheelSize,
                              EngineCapacitiesTruckCar engineCapacity,
                              Set<OptionsCar> options) {
        Car car = searchNeededCar(color, model, wheelSize, engineCapacity, options);
        if (car != null) {
            StorageFactoryCar.get(model).remove(car);
            System.out.println("Машина доставлена со склада");
            return (TruckCar) changeCarAccordingToOrder(car, color, wheelSize, options);
        } else {
            System.out.println("Подходящей машины на складе нет. Новая машина собрана");
            return new TruckCar(color, model, wheelSize, engineCapacity, options);
        }
    }

    public TruckCar createCar(ColorsCar color,
                              ModelsTruckCar model,
                              WheelSizesTruckCar wheelSize,
                              EngineCapacitiesTruckCar engineCapacity) {
        Car car = searchNeededCar(color, model, wheelSize, engineCapacity, null);
        if (car != null) {
            StorageFactoryCar.get(model).remove(car);
            System.out.println("Машина доставлена со склада");
            return (TruckCar) changeCarAccordingToOrder(car, color, wheelSize, null);
        } else {
            System.out.println("Подходящей машины на складе нет. Новая машина собрана");
            return new TruckCar(color, model, wheelSize, engineCapacity, null);
        }
    }

    @Override
    protected TruckCar createRandomCar() {
        return new TruckCar(colors[RANDOM.nextInt(3)],
                ModelsTruckCar.values()[RANDOM.nextInt(3)],
                WheelSizesTruckCar.values()[RANDOM.nextInt(3)],
                EngineCapacitiesTruckCar.values()[RANDOM.nextInt(2)]);
    }

}
