package Homework4.Car;

import Homework4.Enums.*;
import Homework4.Enums.EngineCapacitiesCar.EngineCapacitiesTruckCar;
import Homework4.Enums.ModelsCar.ModelsTruckCar;
import Homework4.Enums.WheelSizesCar.WheelSizesTruckCar;

import java.util.Set;

public class TruckCar extends Car {

    private final Integer loadCapacity; //грузоподъёмность, зависит от объёма двигателя

    public TruckCar(ColorsCar color,
                    ModelsTruckCar model,
                    WheelSizesTruckCar wheelSizesTruckCar,
                    EngineCapacitiesTruckCar engineCapacitiesTruckCar) {
        super(color, model, wheelSizesTruckCar, engineCapacitiesTruckCar);
        this.loadCapacity = installLoadCapacity(engineCapacitiesTruckCar);
    }

    public TruckCar(ColorsCar color,
                    ModelsTruckCar model,
                    WheelSizesTruckCar wheelSizesTruckCar,
                    EngineCapacitiesTruckCar engineCapacitiesTruckCar,
                    Set<OptionsCar> options) {
        super(color, model, wheelSizesTruckCar, engineCapacitiesTruckCar, options);
        this.loadCapacity = installLoadCapacity(engineCapacitiesTruckCar);
    }

    private int installLoadCapacity(EngineCapacitiesTruckCar engineCapacitiesTruckCar) {
        switch (engineCapacitiesTruckCar) {
            case T7200 -> {
                return 10;
            }
            case T8000 -> {
                return 12;
            }
            case T8500 -> {
                return 14;
            }
            case T9200 -> {
                return 16;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Грузовик" +
                "\nцвет: " + getColor().getName() +
                "\nмодель: " + getModel() +
                "\nгод выпуска: " + getYear() +
                "\nразмер колёс: " + getWheelSize() + " дюймов" +
                "\nобъём двигателя: " + getEngineCapacity() +
                "\nгрузоподъёмность: " + loadCapacity + " тонн";
    }
}
