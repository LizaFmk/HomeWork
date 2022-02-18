package Homework4;

//////////////////////////////// Склад ////////////////////////////////

// принимает и хранит созданные заводом автомобили
// ищет подходящий автомобиль по заданным параметрам и отправляет его на завод

import java.util.ArrayList;
import java.util.List;

public class Warehouse {
    private List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    // отправляет на завод полностью подходящий автомобиль либо автомобиль необходимой модели и объёма двигателя
    public Car searchNeededCarInWarehouse(Colors color, Models model, WheelSize wheelSize, EngineCapacity engineCapacity, Options options) {
        Car car = null;
        int[] complianceIndex = new int[cars.size()];
        int minimumIndex = 5;
        int counter = 0;

        for (Car element : cars) {
            complianceIndex[cars.indexOf(element)] = 0;

            if (element.getModel().equals(model.getName()) & element.getEngineCapacity().equals(engineCapacity.getName())) {
                counter++;
                complianceIndex[cars.indexOf(element)] = element.getColor().equals(color.getName()) ? complianceIndex[cars.indexOf(element)] : complianceIndex[cars.indexOf(element)]++;
                complianceIndex[cars.indexOf(element)] = element.getWheelSize().equals(wheelSize.getName()) ? complianceIndex[cars.indexOf(element)] : complianceIndex[cars.indexOf(element)]++;
                if (complianceIndex[cars.indexOf(element)] == 0) {
                    car = element;
                    cars.remove(element);
                    return car;
                } else if (complianceIndex[cars.indexOf(element)] < minimumIndex) {
                    minimumIndex = complianceIndex[cars.indexOf(element)];
                }
            }
        }
        if (counter != 0) {
            for (int i = 0; i < complianceIndex.length; i++) {
                if (complianceIndex[i] == minimumIndex) {
                    car = cars.get(i);
                    cars.remove(i);
                    return car;
                }
            }
        }
        return car;
    }
}
