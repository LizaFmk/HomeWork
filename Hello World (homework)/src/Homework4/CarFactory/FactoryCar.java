package Homework4.CarFactory;

import Homework4.Car.Car;
import Homework4.CarService.ColorServiceCar;
import Homework4.CarService.OptionServiceCar;
import Homework4.Enums.*;
import Homework4.CarService.WheelServiceCar;
import Homework4.Enums.EngineCapacitiesCar.EnumsEngineCapacitiesCar;
import Homework4.Enums.ModelsCar.EnumsModelsCar;
import Homework4.Enums.WheelSizesCar.EnumsWheelSizesCar;

import java.util.*;

public abstract class FactoryCar {

    protected static final Random RANDOM = new Random(0);

    protected final ColorsCar[] colors;
    protected EnumsModelsCar[] models;
    protected EnumsWheelSizesCar[] wheelSizes;
    protected EnumsEngineCapacitiesCar[] engineCapacities;
    protected final Set<OptionsCar> options = new HashSet<>();

    private final ColorServiceCar colorService;
    private final WheelServiceCar wheelService;
    private final OptionServiceCar optionService;

    protected Map<EnumsModelsCar, List<Car>> StorageFactoryCar = new HashMap<>();
    protected final int storageLimit = 3;

    public FactoryCar(WheelServiceCar wheelService,
                      ColorServiceCar colorService,
                      OptionServiceCar optionService) {
        this.wheelService = wheelService;
        this.colorService = colorService;
        this.optionService = optionService;
        this.colors = ColorsCar.values();
        this.options.addAll(List.of(OptionsCar.values()));
    }

    protected <T extends Car> void addToStorage(T car) {
        List<Car> list = StorageFactoryCar.computeIfAbsent(
                car.getModel(),
                model -> new ArrayList<>()
        );
        list.add(car);
    }

    protected Car changeCarAccordingToOrder(Car car,
                                            ColorsCar color,
                                            EnumsWheelSizesCar wheelSize,
                                            Set<OptionsCar> options) {
        if (car.getColor() != color) {
            colorService.change(car, color);
        }
        if (car.getWheelSize() != wheelSize) {
            wheelService.change(car, wheelSize);
        }
        if (options != null) {
            optionService.deleteAllOptions(car);
            optionService.setOptions(car, options);
        }
        return car;
    }

    protected abstract Car createRandomCar();

    protected Car searchNeededCar(ColorsCar color,
                                  EnumsModelsCar model,
                                  EnumsWheelSizesCar wheelSize,
                                  EnumsEngineCapacitiesCar engineCapacity,
                                  Set<OptionsCar> options) {
        List<Car> suitableCars = new ArrayList<>();
        Car tmpCar = null;
        int previousCounter = 0;
        if (StorageFactoryCar.containsKey(model)) {
            if (!StorageFactoryCar.get(model).isEmpty()) {
                for (Car car : StorageFactoryCar.get(model)) {
                    if (car.getEngineCapacity() == engineCapacity) {
                        suitableCars.add(car);
                    }
                }
            } else return null;
        } else return null;
        if (!suitableCars.isEmpty()) {
            previousCounter = getComparingIndex(suitableCars.get(0), color, wheelSize, options);
            tmpCar = suitableCars.get(0);
            if (suitableCars.size() == 1) {
                return tmpCar;
            }
            for (Car car : suitableCars) {
                int currentCounter = getComparingIndex(car, color, wheelSize, options);
                if (currentCounter < previousCounter) {
                    tmpCar = car;
                    previousCounter = currentCounter;
                }
            }
        } else return null;
        return tmpCar;
    }

    private int getComparingIndex(Car car,
                                  ColorsCar colorsCar,
                                  EnumsWheelSizesCar wheelSize,
                                  Set<OptionsCar> options) {
        int index = 0;
        if (car.getWheelSize() != wheelSize) {
            index++;
        }
        if (car.getColor() != colorsCar) {
            index++;
        }
        if (options != null) {
            index += Math.abs(car.getOptions().size() - options.size());
        }
        return index;
    }

    public void startConveyor() {
        System.out.println("???????????????? ???????????? " + this.getClass().getSimpleName() + " ??????????????");
        synchronized (this) {
            while (StorageFactoryCar.size() == storageLimit) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (StorageFactoryCar.size() != storageLimit) {
                addToStorage(this.createRandomCar());
                System.out.println("?????????????? " + this.getClass().getSimpleName() + " ???????????????????? ?? ?????????????????? ???? ?????????? ????????????????????");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.notify();
        }
    }

    public void printAvailableParameters() {
        System.out.println("???????????????? ?????????????????? ???????????????????? ???????????? " + this.getClass().getSimpleName() +
                "\n?????????????????? ??????????: " + Arrays.toString(colors) +
                "\n?????????????????? ????????????: " + Arrays.toString(models) +
                "\n?????????????????? ?????????????? ??????????: " + Arrays.toString(wheelSizes) +
                "\n?????????????????? ???????????? ????????????????????: " + Arrays.toString(engineCapacities) +
                "\n?????????????????? ??????????: " + options);
    }
}
