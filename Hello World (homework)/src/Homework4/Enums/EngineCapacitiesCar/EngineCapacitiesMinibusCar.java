package Homework4.Enums.EngineCapacitiesCar;

import Homework4.Enums.EnumsCar;

public enum EngineCapacitiesMinibusCar implements EnumsEngineCapacitiesCar {
    T2300("2.3"),
    T2500("2.5"),
    T3000("3.0"),
    ;

    private final String name;

    EngineCapacitiesMinibusCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
