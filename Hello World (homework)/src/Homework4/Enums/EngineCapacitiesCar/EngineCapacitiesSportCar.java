package Homework4.Enums.EngineCapacitiesCar;

import Homework4.Enums.EnumsCar;

public enum EngineCapacitiesSportCar implements EnumsEngineCapacitiesCar {
    T1600("1.6"),
    T1600TURBO("1.6 Turbo"),
    T1800("1.8"),
    T1800TURBO("1.8 Turbo"),
    T2000("2.0"),
    T2000TURBO("2.0 Turbo");

    private final String name;

    EngineCapacitiesSportCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
