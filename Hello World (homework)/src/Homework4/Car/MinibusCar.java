package Homework4.Car;

import Homework4.Enums.ModelsCar.ModelsMinibusCar;
import Homework4.Enums.WheelSizesCar.WheelSizesMinibusCar;
import Homework4.Enums.ColorsCar;
import Homework4.Enums.EngineCapacitiesCar.EngineCapacitiesMinibusCar;
import Homework4.Enums.WheelSizesCar.WheelSizesSportCar;
import Homework4.Enums.OptionsCar;

import java.util.Set;

public class MinibusCar extends Car {

    private final Integer passengerCapacity; //пассажировместимость, зависит от модели

    public MinibusCar(ColorsCar color,
                      ModelsMinibusCar model,
                      WheelSizesMinibusCar wheelSizesSportCar,
                      EngineCapacitiesMinibusCar engineCapacitiesMinibusCar) {
        super(color, model, wheelSizesSportCar, engineCapacitiesMinibusCar);
        this.passengerCapacity = installPassengerCapacity(model);
    }

    public MinibusCar(ColorsCar color,
                      ModelsMinibusCar model,
                      WheelSizesMinibusCar wheelSizeMinibusCar,
                      EngineCapacitiesMinibusCar engineCapacitiesMinibusCar,
                      Set<OptionsCar> options) {
        super(color, model, wheelSizeMinibusCar, engineCapacitiesMinibusCar, options);
        this.passengerCapacity = installPassengerCapacity(model);
    }

    private int installPassengerCapacity(ModelsMinibusCar model) {
        switch (model) {
            case MASTER -> {
                return 12;
            }
            case TRAFIC -> {
                return 14;
            }
            case MASCOTT -> {
                return 16;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Микроавтобус" +
                "\nцвет: " + getColor().getName() +
                "\nмодель: " + getModel() +
                "\nгод выпуска: " + getYear() +
                "\nразмер колёс: " + getWheelSize() + " дюймов" +
                "\nобъём двигателя: " + getEngineCapacity() +
                "\nпассажировместимость: " + passengerCapacity + " человек";
    }
}
