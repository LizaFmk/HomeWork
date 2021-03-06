package Homework4.Enums.EngineCapacitiesCar;

import Homework4.Enums.EnumsCar;

public enum EngineCapacitiesTruckCar implements EnumsEngineCapacitiesCar {
    T7200("7.2"),
    T8000("8.0"),
    T8500("8.5"),
    T9200("9.2");

    private final String name;

    EngineCapacitiesTruckCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
