package Homework3.Task4;

public class Main {
    public static void main(String[] args) {
        Car carBmw = new Car("bmw", "оранжевый");
        System.out.println(carBmw.getCarBrand());
        System.out.println(carBmw.getCarColor());

        carBmw.changeCarColor("зеленый");
    }
}
