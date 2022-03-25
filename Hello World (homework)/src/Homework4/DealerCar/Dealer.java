package Homework4.DealerCar;

import Homework4.Car.Car;
import Homework4.CarFactory.FactoryMinibusCar;
import Homework4.CarFactory.FactorySportCar;
import Homework4.CarFactory.FactoryTruckCar;
import Homework4.CarService.ColorServiceCar;
import Homework4.CarService.OptionServiceCar;
import Homework4.Enums.*;
import Homework4.CarService.WheelServiceCar;
import Homework4.Enums.EngineCapacitiesCar.EngineCapacitiesMinibusCar;
import Homework4.Enums.EngineCapacitiesCar.EngineCapacitiesSportCar;
import Homework4.Enums.EngineCapacitiesCar.EngineCapacitiesTruckCar;
import Homework4.Enums.EngineCapacitiesCar.EnumsEngineCapacitiesCar;
import Homework4.Enums.ModelsCar.EnumsModelsCar;
import Homework4.Enums.ModelsCar.ModelsMinibusCar;
import Homework4.Enums.ModelsCar.ModelsSportCar;
import Homework4.Enums.ModelsCar.ModelsTruckCar;
import Homework4.Enums.WheelSizesCar.EnumsWheelSizesCar;
import Homework4.Enums.WheelSizesCar.WheelSizesMinibusCar;
import Homework4.Enums.WheelSizesCar.WheelSizesSportCar;
import Homework4.Enums.WheelSizesCar.WheelSizesTruckCar;

import java.util.Set;

public record Dealer(WheelServiceCar wheelService,
                     ColorServiceCar colorService,
                     OptionServiceCar optionService,
                     FactoryMinibusCar factoryMinibusCar,
                     FactoryTruckCar factoryTruckCar,
                     FactorySportCar factorySportCar) {

    public Car orderCar(ColorsCar color,
                        EnumsModelsCar model,
                        EnumsWheelSizesCar wheelSize,
                        EnumsEngineCapacitiesCar engineCapacity,
                        Set<OptionsCar> options) {
        if (model instanceof ModelsMinibusCar) {
            return factoryMinibusCar.createCar(color,
                                              (ModelsMinibusCar) model,
                                              (WheelSizesMinibusCar) wheelSize,
                                              (EngineCapacitiesMinibusCar) engineCapacity,
                                               options);
        } else if (model instanceof ModelsTruckCar) {
            return factoryTruckCar.createCar(color,
                                            (ModelsTruckCar) model,
                                            (WheelSizesTruckCar) wheelSize,
                                            (EngineCapacitiesTruckCar) engineCapacity,
                                             options);
        } else if (model instanceof ModelsSportCar) {
            return factorySportCar.createCar(color,
                                            (ModelsSportCar) model,
                                            (WheelSizesSportCar) wheelSize,
                                            (EngineCapacitiesSportCar) engineCapacity,
                                             options);
        } else
            throw new IllegalArgumentException(ExceptionMessages.ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE.getText());
    }

    public <T extends Car> T orderCar(ColorsCar color,
                                      EnumsModelsCar model,
                                      EnumsWheelSizesCar wheelSize,
                                      EnumsEngineCapacitiesCar engineCapacity) {
        if (model instanceof ModelsMinibusCar) {
            return (T) factoryMinibusCar.createCar(color,
                    (ModelsMinibusCar) model,
                    (WheelSizesMinibusCar) wheelSize,
                    (EngineCapacitiesMinibusCar) engineCapacity);
        } else if (model instanceof ModelsTruckCar) {
            return (T) factoryTruckCar.createCar(color,
                    (ModelsTruckCar) model,
                    (WheelSizesTruckCar) wheelSize,
                    (EngineCapacitiesTruckCar) engineCapacity);
        } else if (model instanceof ModelsSportCar) {
            return (T) factorySportCar.createCar(color,
                    (ModelsSportCar) model,
                    (WheelSizesSportCar) wheelSize,
                    (EngineCapacitiesSportCar) engineCapacity);
        } else
            throw new IllegalArgumentException(ExceptionMessages.ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE.getText());
    }

    public Car changeWheelSize(Car car, EnumsWheelSizesCar wheelSize) {
        return wheelService.change(car, wheelSize);
    }

    public Car changeColor(Car car, ColorsCar color) {
        if (car != null) {
            return colorService.change(car, color);
        } else {
            throw new NullPointerException("Цвет не был изменён: " + ExceptionMessages.NULL_POINTER_EXCEPTION_MESSAGE.getText());
        }
    }

    public Car deleteOption(Car car, OptionsCar option) {
        if (car != null) {
            return optionService.change(car, option);
        } else {
            throw new NullPointerException("Опция не была удалена: " + ExceptionMessages.NULL_POINTER_EXCEPTION_MESSAGE.getText());
        }
    }

    public Car addOption(Car car, OptionsCar option) {
        if (car != null) {
            return optionService.change(car, option);
        } else {
            throw new NullPointerException("Опция не была добавлена :" + ExceptionMessages.NULL_POINTER_EXCEPTION_MESSAGE.getText());
        }
    }
}
