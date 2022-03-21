package Homework4.Enums.ModelsCar;

import Homework4.Enums.EngineCapacitiesCar.EngineCapacitiesTruckCar;
import Homework4.Enums.WheelSizesCar.WheelSizesTruckCar;

public enum ModelsTruckCar {
    KERAX("Kerax",
            new EngineCapacitiesTruckCar[]{EngineCapacitiesTruckCar.T7200, EngineCapacitiesTruckCar.T8000},
            new WheelSizesTruckCar[]{WheelSizesTruckCar.INCH60, WheelSizesTruckCar.INCH70, WheelSizesTruckCar.INCH80}),
    PREMIUM("Premium",
            new EngineCapacitiesTruckCar[]{EngineCapacitiesTruckCar.T8000, EngineCapacitiesTruckCar.T8500},
            new WheelSizesTruckCar[]{WheelSizesTruckCar.INCH60, WheelSizesTruckCar.INCH70, WheelSizesTruckCar.INCH80}),
    MIDLINER("Midliner",
            new EngineCapacitiesTruckCar[]{EngineCapacitiesTruckCar.T8500, EngineCapacitiesTruckCar.T9200},
            new WheelSizesTruckCar[]{WheelSizesTruckCar.INCH60, WheelSizesTruckCar.INCH70, WheelSizesTruckCar.INCH80}),
    ;

    private final String name;
    private final EngineCapacitiesTruckCar[] engineCapacitiesTruckCar;
    private final WheelSizesTruckCar[] wheelSizesTruckCar;

    ModelsTruckCar(String name, EngineCapacitiesTruckCar[] engineCapacitiesTruckCar, WheelSizesTruckCar[] wheelSizesTruckCar) {
        this.name = name;
        this.engineCapacitiesTruckCar = engineCapacitiesTruckCar;
        this.wheelSizesTruckCar = wheelSizesTruckCar;
    }

    public String getName() {
        return name;
    }

    public EngineCapacitiesTruckCar[] getEngineCapacity() {
        return engineCapacitiesTruckCar;
    }

    public WheelSizesTruckCar[] getWheelSizes() {
        return wheelSizesTruckCar;
    }
}
