package Homework4.CarFactory;

import Homework4.Car.Car;
import Homework4.Car.MinibusCar;
import Homework4.CarService.ColorServiceCar;
import Homework4.CarService.OptionServiceCar;
import Homework4.CarService.WheelServiceCar;
import Homework4.Enums.EngineCapacitiesCar.EngineCapacitiesMinibusCar;
import Homework4.Enums.ModelsCar.ModelsMinibusCar;
import Homework4.Enums.WheelSizesCar.WheelSizesMinibusCar;
import Homework4.Enums.ColorsCar;
import Homework4.Enums.OptionsCar;

import java.util.Set;

public class FactoryMinibusCar extends FactoryCar {

    public FactoryMinibusCar(WheelServiceCar wheelService, ColorServiceCar colorService, OptionServiceCar optionService) {
        super(wheelService, colorService, optionService);
        this.models = ModelsMinibusCar.values();
        this.engineCapacities = EngineCapacitiesMinibusCar.values();
        this.wheelSizes = WheelSizesMinibusCar.values();
    }

    public MinibusCar createCar(ColorsCar color,
                                ModelsMinibusCar model,
                                WheelSizesMinibusCar wheelSize,
                                EngineCapacitiesMinibusCar engineCapacity,
                                Set<OptionsCar> options) {
        Car car = searchNeededCar(color, model, wheelSize, engineCapacity, options);
        if (car != null) {
            StorageFactoryCar.get(model).remove(car);
            System.out.println("Машина доставлена со склада");
            return (MinibusCar) changeCarAccordingToOrder(car, color, wheelSize, options);
        } else {
            System.out.println("Подходящей машины на складе нет. Новая машина собрана");
            return new MinibusCar(color, model, wheelSize, engineCapacity, options);
        }
    }

    public MinibusCar createCar(ColorsCar color,
                                ModelsMinibusCar model,
                                WheelSizesMinibusCar wheelSize,
                                EngineCapacitiesMinibusCar engineCapacity) {
        Car car = searchNeededCar(color, model, wheelSize, engineCapacity, null);
        if (car != null) {
            StorageFactoryCar.get(model).remove(car);
            System.out.println("Машина доставлена со склада");
            return (MinibusCar) changeCarAccordingToOrder(car, color, wheelSize, null);
        } else {
            System.out.println("Подходящей машины на складе нет. Новая машина собрана");
            return new MinibusCar(color, model, wheelSize, engineCapacity);
        }
    }

    @Override
    protected MinibusCar createRandomCar() {
        return new MinibusCar(colors[RANDOM.nextInt(3)],
                ModelsMinibusCar.values()[RANDOM.nextInt(3)],
                WheelSizesMinibusCar.values()[RANDOM.nextInt(3)],
                EngineCapacitiesMinibusCar.values()[RANDOM.nextInt(2)]);
    }

}
