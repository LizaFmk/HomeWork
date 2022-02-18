package Homework4;

//////////////////////////////// Салон ////////////////////////////////

// заказыывает автомобили на заводе
// отправляет автомобили в сервис

public class MazdaDealer {

    private MazdaService mazdaService;
    private MazdaFactory mazdaFactory;

    public MazdaDealer() {
        this.mazdaService = new MazdaService();
        this.mazdaFactory = new MazdaFactory();
    }

    public Car orderCar(Colors color, Models model, WheelSize wheelSize, EngineCapacity engineCapacity, Options options) {
        return mazdaFactory.createCar(color, model, wheelSize, engineCapacity, options);
    }

    public Car orderCar(Colors color, Models model, WheelSize wheelSize, EngineCapacity engineCapacity) {
        return mazdaFactory.createCar(color, model, wheelSize, engineCapacity, null);
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
