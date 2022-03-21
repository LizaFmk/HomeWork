package Homework4;

import Homework4.Car.MinibusCar;
import Homework4.Car.SportCar;
import Homework4.Car.TruckCar;
import Homework4.CarFactory.FactoryCar;
import Homework4.CarFactory.FactoryMinibusCar;
import Homework4.CarFactory.FactorySportCar;
import Homework4.CarFactory.FactoryTruckCar;
import Homework4.CarService.ColorServiceCar;
import Homework4.CarService.OptionServiceCar;
import Homework4.CarService.WheelServiceCar;
import Homework4.DealerCar.Dealer;
import Homework4.Enums.ColorsCar;
import Homework4.Enums.EngineCapacitiesCar.EngineCapacitiesMinibusCar;
import Homework4.Enums.EngineCapacitiesCar.EngineCapacitiesSportCar;
import Homework4.Enums.EngineCapacitiesCar.EngineCapacitiesTruckCar;
import Homework4.Enums.ExceptionMessages;
import Homework4.Enums.ModelsCar.ModelsMinibusCar;
import Homework4.Enums.ModelsCar.ModelsSportCar;
import Homework4.Enums.ModelsCar.ModelsTruckCar;
import Homework4.Enums.OptionsCar;
import Homework4.Enums.WheelSizesCar.WheelSizesMinibusCar;
import Homework4.Enums.WheelSizesCar.WheelSizesSportCar;
import Homework4.Enums.WheelSizesCar.WheelSizesTruckCar;

import java.lang.reflect.Executable;

public class Main {
    public static void main(String[] args) {
        ColorServiceCar colorService = new ColorServiceCar();
        WheelServiceCar wheelService = new WheelServiceCar();
        OptionServiceCar optionService = new OptionServiceCar();

        FactoryMinibusCar factoryMinibusCar = new FactoryMinibusCar(wheelService, colorService, optionService);
        FactoryTruckCar factoryTruckCar = new FactoryTruckCar(wheelService, colorService, optionService);
        FactorySportCar factorySportCar = new FactorySportCar(wheelService, colorService, optionService);

        Thread conveyorMinibusCar = new Thread(factoryMinibusCar::startConveyor);
        Thread conveyorTruckCar = new Thread(factoryTruckCar::startConveyor);
        Thread conveyorSportCar = new Thread(factorySportCar::startConveyor);

        conveyorMinibusCar.start();
        conveyorTruckCar.start();
        conveyorSportCar.start();

        try {
            conveyorMinibusCar.join();
            conveyorTruckCar.join();
            conveyorSportCar.join();
        } catch (InterruptedException ignored) {
        }

        Dealer dealerCar = new Dealer(wheelService, colorService, optionService, factoryMinibusCar, factoryTruckCar, factorySportCar);

//        factoryMinibusCar.printAvailableParameters();
//        factoryTruckCar.printAvailableParameters();
//        factorySportCar.printAvailableParameters();

        SportCar myNewSportCar = null;
        MinibusCar myNewMinibusCar = null;
        TruckCar myNewTruckCar = null;

        try {
            myNewSportCar = dealerCar.orderCar(ColorsCar.BLACK, ModelsSportCar.CLIOV6, WheelSizesSportCar.INCH16, EngineCapacitiesSportCar.T1600TURBO);
            myNewMinibusCar = dealerCar.orderCar(ColorsCar.RED, ModelsMinibusCar.MASCOTT, WheelSizesMinibusCar.INCH18, EngineCapacitiesMinibusCar.T2300);
            myNewTruckCar = dealerCar.orderCar(ColorsCar.SILVER, ModelsTruckCar.PREMIUM, WheelSizesTruckCar.INCH60, EngineCapacitiesTruckCar.T9200);
        } catch (ClassCastException e) {
            System.err.println(ExceptionMessages.CLASS_CAST_EXCEPTION_MESSAGE.getText());
        }

        dealerCar.changeColor(myNewSportCar, ColorsCar.RED);

    }
}
