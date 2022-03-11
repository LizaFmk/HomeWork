package Homework6;

import java.util.ArrayList;
import java.util.List;

public class Country {

    private static final int LIMIT = 20;
    private Factory factory;
    private int army;
    private volatile boolean consumer = true;
    private final String name;
    private List<PartsOfRobot> partsOfRobot;

    public Country(String name, Factory factory) {
        this.name = name;
        this.army = 0;
        this.partsOfRobot = new ArrayList<>();
        this.factory = factory;
    }

    public void collectPartsOfRobot() {
            while (consumer) {
                synchronized (Factory.getStorage()) {
                    PartsOfRobot p = returnNecessaryPart();
                    if (p != null) {
                        p = factory.getFromStorage(p);
                        if (p != null) {
                            partsOfRobot.add(p.getIndex(), p);
                            if (partsOfRobot.size() == 6) {
                                createAndAddRobotToArmy();
                                partsOfRobot.clear();
                            }
                        } else try {
                            Factory.getStorage().notify();
                            Factory.getStorage().wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
    }

    private void createAndAddRobotToArmy() {
        army++;
        System.out.println("В АРМИИ СТРАНЫ " + this.name + " УЖЕ " + this.army + " БОЙЦОВ!");
        if (army == LIMIT) {
            System.out.println("ПОБЕДИЛА АРМИЯ СТРАНЫ " + this.name);
            System.exit(0);
        }
    }

    private PartsOfRobot returnNecessaryPart() {
        for (int i = 0; i < PartsOfRobot.values().length; i++) {
            if (!partsOfRobot.contains(PartsOfRobot.values()[i])) {
                return PartsOfRobot.values()[i];
            }
        }
        return null;
    }
}
