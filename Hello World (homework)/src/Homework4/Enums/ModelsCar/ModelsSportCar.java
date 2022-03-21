package Homework4.Enums.ModelsCar;

import Homework4.Enums.EngineCapacitiesCar.EngineCapacitiesSportCar;
import Homework4.Enums.WheelSizesCar.WheelSizesSportCar;

public enum ModelsSportCar {
    R5TURBO("R5 Turbo",
            new EngineCapacitiesSportCar[]{EngineCapacitiesSportCar.T1600, EngineCapacitiesSportCar.T1600TURBO},
            new WheelSizesSportCar[]{WheelSizesSportCar.INCH16, WheelSizesSportCar.INCH17, WheelSizesSportCar.INCH18}),
    CLIOV6("Clio V6",
            new EngineCapacitiesSportCar[]{EngineCapacitiesSportCar.T1800, EngineCapacitiesSportCar.T1800TURBO},
            new WheelSizesSportCar[]{WheelSizesSportCar.INCH16, WheelSizesSportCar.INCH17, WheelSizesSportCar.INCH18}),
    MEGANER26R("Megane R26.R",
            new EngineCapacitiesSportCar[]{EngineCapacitiesSportCar.T2000, EngineCapacitiesSportCar.T2000TURBO},
            new WheelSizesSportCar[]{WheelSizesSportCar.INCH16, WheelSizesSportCar.INCH17, WheelSizesSportCar.INCH18}),
    ;

    private final String name;
    private final EngineCapacitiesSportCar[] engineCapacity;
    private final WheelSizesSportCar[] wheelSizesSportCars;

    ModelsSportCar(String name, EngineCapacitiesSportCar[] engineCapacity, WheelSizesSportCar[] wheelSizesSportCars) {
        this.name = name;
        this.engineCapacity = engineCapacity;
        this.wheelSizesSportCars = wheelSizesSportCars;
    }

    public String getName() {
        return name;
    }

    public EngineCapacitiesSportCar[] getEngineCapacity() {
        return engineCapacity;
    }

    public WheelSizesSportCar[] getWheelSizes() {
        return wheelSizesSportCars;
    }
}
