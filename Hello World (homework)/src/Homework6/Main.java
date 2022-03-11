package Homework6;

public class Main {
    public static void main(String[] args) {
        Factory factory = new Factory();

        Country countryOne = new Country("ONE", factory);
        Country countryTwo = new Country("TWO", factory);

        Thread factoryThread = new Thread(factory::fillTheStorage);
        Thread countryOneThread = new Thread(countryOne::collectPartsOfRobot);
        Thread countryTwoThread = new Thread(countryTwo::collectPartsOfRobot);

        factoryThread.start();
        countryOneThread.start();
        countryTwoThread.start();
        try {
            factoryThread.join();
            countryOneThread.join();
            countryTwoThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
