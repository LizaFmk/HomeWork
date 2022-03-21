package Homework4.Car;

import Homework4.Enums.ColorsCar;
import Homework4.Enums.EngineCapacitiesCar.EngineCapacitiesSportCar;
import Homework4.Enums.WheelSizesCar.WheelSizesSportCar;
import Homework4.Enums.ModelsCar.ModelsSportCar;
import Homework4.Enums.OptionsCar;

import java.util.Set;

//////////////////////////////// Спорткар ////////////////////////////////

public class SportCar extends Car {

    private final Double accelerationTo100; // разгон до сотни, зависит от объёма двигателя

    public SportCar(ColorsCar color,
                    ModelsSportCar model,
                    WheelSizesSportCar wheelSizesSportCar,
                    EngineCapacitiesSportCar engineCapacitiesSportCar) {
        super(color, model, wheelSizesSportCar, engineCapacitiesSportCar);
        this.accelerationTo100 = installAccelerationTo100(engineCapacitiesSportCar);
    }

    public SportCar(ColorsCar color,
                    ModelsSportCar model,
                    WheelSizesSportCar wheelSizesSportCar,
                    EngineCapacitiesSportCar engineCapacitiesSportCar,
                    Set<OptionsCar> options) {
        super(color, model, wheelSizesSportCar, engineCapacitiesSportCar, options);
        this.accelerationTo100 = installAccelerationTo100(engineCapacitiesSportCar);
    }

    private double installAccelerationTo100(EngineCapacitiesSportCar engineCapacitiesSportCar) {
        switch (engineCapacitiesSportCar) {
            case T1600 -> {
                return 5.5;
            }
            case T1600TURBO -> {
                return 4.0;
            }
            case T1800 -> {
                return 5.0;
            }
            case T1800TURBO -> {
                return 3.5;
            }
            case T2000 -> {
                return 4.5;
            }
            case T2000TURBO -> {
                return 3.0;
            }
        }
        return 0.0;
    }

    @Override
    public String toString() {
        return "Спорткар" +
                "\nцвет: " + getColor().getName() +
                "\nмодель: " + getModel() +
                "\nгод выпуска: " + getYear() +
                "\nразмер колёс: " + getWheelSize() + " дюймов" +
                "\nобъём двигателя: " + getEngineCapacity() +
                "\nразгон до сотни: " + accelerationTo100 + " секунд";
    }
}
