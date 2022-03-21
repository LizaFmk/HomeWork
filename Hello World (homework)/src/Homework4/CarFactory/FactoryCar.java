package Homework4.CarFactory;

import Homework4.Car.Car;
import Homework4.CarService.ColorServiceCar;
import Homework4.CarService.OptionServiceCar;
import Homework4.Enums.*;
import Homework4.CarService.WheelServiceCar;
import Homework4.Enums.EngineCapacitiesCar.EngineCapacitiesTruckCar;
import Homework4.Enums.ModelsCar.ModelsTruckCar;
import Homework4.Enums.WheelSizesCar.WheelSizesSportCar;
import Homework4.Enums.WheelSizesCar.WheelSizesTruckCar;

import java.util.*;

public abstract class FactoryCar {

    protected static final Random RANDOM = new Random(0);

    protected final ColorsCar[] colors;
    protected Enum[] models;
    protected Enum[] wheelSizes;
    protected Enum[] engineCapacities;
    protected final Set<OptionsCar> options = new HashSet<>();

    private final ColorServiceCar colorService;
    private final WheelServiceCar wheelService;
    private final OptionServiceCar optionService;

    protected Map<Enum, List<Car>> StorageFactoryCar = new HashMap<>();
    protected final int storageLimit = 3;

    public FactoryCar(WheelServiceCar wheelService, ColorServiceCar colorService, OptionServiceCar optionService) {
        this.wheelService = wheelService;
        this.colorService = colorService;
        this.optionService = optionService;
        this.colors = ColorsCar.values();
        this.options.addAll(List.of(OptionsCar.values()));
    }

    protected Car searchNeededCar(ColorsCar color,
                                  Enum model,
                                  Enum wheelSize,
                                  Enum engineCapacity,
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

    protected abstract Car createRandomCar();

    private int getComparingIndex(Car car,
                                  ColorsCar colorsCar,
                                  Enum wheelSize,
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

    protected Car changeCarAccordingToOrder(Car car,
                                            ColorsCar color,
                                            Enum wheelSize,
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

    protected <T extends Car> void addToStorage(T car) {
        List<Car> list = StorageFactoryCar.computeIfAbsent(
                car.getModel(),
                model -> new ArrayList<>()
        );
        list.add(car);
    }

    public void startConveyor() {
        System.out.println("Конвейер завода " + this.getClass().getSimpleName() + " запущен");
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
                System.out.println("Фабрика " + this.getClass().getSimpleName() + " изготовила и отправила на склад автомобиль");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.notify();
        }
    }

    public void printAvailableParameters() {
        System.out.println("Перечень доступных параметров завода " + this.getClass().getSimpleName() +
        "\nДоступные цвета: " + Arrays.toString(colors) +
        "\nДоступные модели: " + Arrays.toString(models) +
        "\nДоступные размеры колёс: " + Arrays.toString(wheelSizes) +
        "\nДоступные объёмы двигателей: " + Arrays.toString(engineCapacities) +
        "\nДоступные опции: " + options);
    }
}
