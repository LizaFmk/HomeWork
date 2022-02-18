package Homework4;

import java.util.*;

//////////////////////////////// Завод ////////////////////////////////

// при создании завода задаёт список доступных параметров; изготавливает несколько рандомных автомобилей и отправляет их на свой склад
// изготавливает автомобили по запросу автосалона (дилера)
// при получении запроса от автосалона сначала проверяет, нет ли подходящего автомобиля на складе;
// при необходимости отправляет в сервис на изменение и передаёт в автосалон; если подходящего на складе нет - создаёт новый автомобиль

public class MazdaFactory {

    private Colors[] colors;
    private Models[] models;
    private WheelSize[] wheelSizes;
    private EngineCapacity[] engineCapacities;
    private Set<Options> options;
    private MazdaService mazdaService = new MazdaService();

    //склад
    private Warehouse warehouse = new Warehouse();

    public MazdaFactory() {
        this.models = new Models[]{Models.CX5, Models.CX7, Models.CX9};
        this.colors = new Colors[]{Colors.RED, Colors.BLACK, Colors.SILVER, Colors.WHITE};
        this.wheelSizes = new WheelSize[]{WheelSize.INCH16, WheelSize.INCH17, WheelSize.INCH18};
        this.engineCapacities = new EngineCapacity[]{EngineCapacity.T1800, EngineCapacity.T2000, EngineCapacity.T2300};
        this.options = new HashSet<>(Arrays.asList(Options.BLUETOOTH, Options.PARKTRONIC, Options.STEREOSYSTEM));
        warehouse.addCar(new Car(Colors.WHITE, Models.CX5, 2022, WheelSize.INCH16, EngineCapacity.T1800));
        warehouse.addCar(new Car(Colors.BLACK, Models.CX7, 2022, WheelSize.INCH17, EngineCapacity.T2000));
        warehouse.addCar(new Car(Colors.SILVER, Models.CX9, 2022, WheelSize.INCH18, EngineCapacity.T2300));
    }

    public Car createCar(Colors color, Models model, WheelSize wheelSize, EngineCapacity engineCapacity, Options options) {
        Car car = warehouse.searchNeededCarInWarehouse(color, model, wheelSize, engineCapacity, options);
        if (car != null) {
            if (!car.getColor().equals(color.getName())) {
                mazdaService.changeColor(car, color);
            }
            if (!car.getWheelSize().equals(wheelSize.getName())) {
                mazdaService.changeWheelSize(car, wheelSize);
            }
            mazdaService.setOptions(car, options);
            return car;
        } else return new Car(color, model, 2022, wheelSize, engineCapacity, options);
    }

    @Override
    public String toString() {
        return "Список доступных параметров автомобилей MAZDA" +
                "\nцвета: " + Arrays.toString(colors) +
                "\nмодели: " + Arrays.toString(models) +
                "\nразмеры колёс: " + Arrays.toString(wheelSizes) +
                "\nобъёмы двигателя: " + Arrays.toString(engineCapacities) +
                "\nопции: " + options;
    }
}
