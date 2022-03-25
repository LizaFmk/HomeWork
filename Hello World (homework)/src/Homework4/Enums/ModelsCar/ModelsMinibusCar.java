package Homework4.Enums.ModelsCar;

import Homework4.Enums.EngineCapacitiesCar.EngineCapacitiesMinibusCar;
import Homework4.Enums.WheelSizesCar.WheelSizesSportCar;

public enum ModelsMinibusCar implements EnumsModelsCar {
    MASTER("Renault Master",
            new EngineCapacitiesMinibusCar[]{EngineCapacitiesMinibusCar.T2300, EngineCapacitiesMinibusCar.T2500},
            new WheelSizesSportCar[]{WheelSizesSportCar.INCH16, WheelSizesSportCar.INCH17, WheelSizesSportCar.INCH18}),
    MASCOTT("Renault Mascott",
            new EngineCapacitiesMinibusCar[]{EngineCapacitiesMinibusCar.T2500, EngineCapacitiesMinibusCar.T3000},
            new WheelSizesSportCar[]{WheelSizesSportCar.INCH16, WheelSizesSportCar.INCH17, WheelSizesSportCar.INCH18}),
    TRAFIC("Renault Trafic",
            new EngineCapacitiesMinibusCar[]{EngineCapacitiesMinibusCar.T2300, EngineCapacitiesMinibusCar.T3000},
            new WheelSizesSportCar[]{WheelSizesSportCar.INCH16, WheelSizesSportCar.INCH17, WheelSizesSportCar.INCH18}),
    ;

    private final String name;
    private final EngineCapacitiesMinibusCar[] engineCapacitiesMinibusCars;
    private final WheelSizesSportCar[] wheelSizesSportCars;

    ModelsMinibusCar(String name, EngineCapacitiesMinibusCar[] engineCapacitiesMinibusCars, WheelSizesSportCar[] wheelSizesSportCars) {
        this.name = name;
        this.engineCapacitiesMinibusCars = engineCapacitiesMinibusCars;
        this.wheelSizesSportCars = wheelSizesSportCars;
    }

    public String getName() {
        return name;
    }

    public EngineCapacitiesMinibusCar[] getEngineCapacity() {
        return engineCapacitiesMinibusCars;
    }

    public WheelSizesSportCar[] getWheelSizes() {
        return wheelSizesSportCars;
    }
}
