package Homework4;

public class Main {
    public static void main(String[] args) {
        MazdaFactory mazdaFactory = new MazdaFactory();
        MazdaFactory.MazdaService mazdaService = mazdaFactory.new MazdaService();
        MazdaFactory.MazdaDealer mazdaDealer = mazdaFactory.new MazdaDealer(mazdaService);

        MazdaFactory.Car myNewCar = mazdaDealer.orderCar(Colors.RED, Models.CX5, WheelSize.INCH17, EngineCapacity.T1800);

        mazdaDealer.addOption(myNewCar, Options.BLUETOOTH);

        mazdaDealer.changeWheelSize(myNewCar, WheelSize.INCH18);

        System.out.println(myNewCar);
    }
}
