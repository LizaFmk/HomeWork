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

    private Car createCar(Colors color, Models model, WheelSize wheelSize, EngineCapacity engineCapacity, Options options) {
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

    public void print() {
        System.out.println(warehouse.cars);
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

    //////////////////////////////// Склад ////////////////////////////////

    // принимает и хранит созданные заводом автомобили
    // ищет подходящий автомобиль по заданным параметрам и отправляет его на завод

    private class Warehouse {
        private List<Car> cars = new ArrayList<>();

        private void addCar(Car car) {
            cars.add(car);
        }

        // отправляет на завод полностью подходящий автомобиль либо автомобиль необходимой модели и объёма двигателя
        private Car searchNeededCarInWarehouse(Colors color, Models model, WheelSize wheelSize, EngineCapacity engineCapacity, Options options) {
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

        //////////////////////////////// Салон ////////////////////////////////

        // заказыывает автомобили на заводе
        // отправляет автомобили в сервис

        public class MazdaDealer {

            private MazdaService mazdaService;

            public MazdaDealer(MazdaService mazdaService) {
                this.mazdaService = mazdaService;
            }

            public Car orderCar(Colors color, Models model, WheelSize wheelSize, EngineCapacity engineCapacity, Options options) {
                return createCar(color, model, wheelSize, engineCapacity, options);
            }

            public Car orderCar(Colors color, Models model, WheelSize wheelSize, EngineCapacity engineCapacity) {
                return createCar(color, model, wheelSize, engineCapacity, null);
            }

            public Car changeWheelSize(Car car, WheelSize wheelSize) {
                return mazdaService.changeWheelSize(car, wheelSize);
            }

            public Car changeColor(Car car, Colors color) {
                return mazdaService.changeColor(car, color);
            }

            public Car deleteOption(Car car, Options option) {
                return mazdaService.deleteOption(car, option);
            }

            public Car addOption(Car car, Options option) {
                return mazdaService.addOption(car, option);
            }
        }

        //////////////////////////////// Сервис ////////////////////////////////

        // меняет цвет, размер колёс, устанавливает-добавляет-удаляет опции и отправляет обратно в автосалон

        public class MazdaService {
            private Car changeWheelSize(Car car, WheelSize wheelSize) {
                car.setWheelSize(wheelSize.getName());
                return car;
            }

            private Car changeColor(Car car, Colors color) {
                car.setColor(color.getName());
                return car;
            }

            private Car setOptions(Car car, Options options) {
                car.setOptions(options);
                return car;
            }

            private Car deleteOption(Car car, Options option) {
                car.deteleOption(option);
                return car;
            }

            private Car addOption(Car car, Options option) {
                car.addOption(option);
                return car;
            }
        }

        //////////////////////////////// Автомобиль ////////////////////////////////

        public class Car {
            private String color;
            private final String model;
            private final Integer releaseYear;
            private String wheelSize;
            private String engineCapacity;
            private Set<Options> options;

            private Car(Colors color, Models model, Integer releaseYear, WheelSize wheelSize, EngineCapacity engineCapacity) {
                this.color = color.getName();
                this.model = model.getName();
                this.releaseYear = releaseYear;
                this.wheelSize = wheelSize.getName();
                this.engineCapacity = engineCapacity.getName();
                this.options = new HashSet<>();
            }

            private Car(Colors color, Models model, Integer releaseYear, WheelSize wheelSize, EngineCapacity engineCapacity, Options options) {
                this.color = color.getName();
                this.model = model.getName();
                this.releaseYear = releaseYear;
                this.wheelSize = wheelSize.getName();
                this.engineCapacity = engineCapacity.getName();
                this.options.add(options);
            }

            public String getColor() {
                return color;
            }

            private void setColor(String color) {
                this.color = color;
            }

            public String getModel() {
                return model;
            }

            public Integer getReleaseYear() {
                return releaseYear;
            }

            public String getWheelSize() {
                return wheelSize;
            }

            private void setWheelSize(String wheelSize) {
                this.wheelSize = wheelSize;
            }

            public String getEngineCapacity() {
                return engineCapacity;
            }

            private void setEngineCapacity(String engineCapacity) {
                this.engineCapacity = engineCapacity;
            }

            public Set<Options> getOptions() {
                return options;
            }

            private void setOptions(Options options) {
                this.options.add(options);
            }

            private void deteleOption(Options option) {
                this.options.remove(option);
            }

            private void addOption(Options option) {
                this.options.add(option);
            }

            @Override
            public String toString() {
                return "Автомобиль MAZDA" +
                        "\nцвет: " + color +
                        "\nмодель: " + model +
                        "\nгод выпуска: " + releaseYear +
                        "\nразмер колёс: " + wheelSize +
                        "\nобъём двигателя: " + engineCapacity +
                        "\nопции: " + options;
            }
        }
}
