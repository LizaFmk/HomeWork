package Homework6;

import java.util.*;

public class Factory {

    private static final Random RANDOM = new Random(0);
    private static final Map<Integer, List<PartsOfRobot>> STORAGE = new HashMap<>();
    private volatile boolean producer = true;

    public void fillTheStorage() {
            while (producer) {
                synchronized (STORAGE) {
                    generatePartOfRobotAndAddToStorage();
                    try {
                        STORAGE.wait();
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                        producer = false;
                    }
                    STORAGE.notify();
                }
            }
        }

    private void generatePartOfRobotAndAddToStorage() {
        int index = RANDOM.nextInt(6);
        PartsOfRobot partsOfRobot = PartsOfRobot.values()[index];
        List<PartsOfRobot> list = STORAGE.computeIfAbsent(
                index,
                parts -> new ArrayList<>()
        );
        list.add(partsOfRobot);
        System.out.println("Завод изготовил и отправил на склад элемент: " + partsOfRobot.getName());
    }

    public PartsOfRobot getFromStorage(PartsOfRobot necessaryPart) {
            if (STORAGE.get(necessaryPart.getIndex()) != null) {
                if (STORAGE.get(necessaryPart.getIndex()).size() != 0) {
                    return STORAGE.get(necessaryPart.getIndex()).remove(0);
                }
            }
        return null;
    }

    public static Map<Integer, List<PartsOfRobot>> getStorage() {
        return STORAGE;
    }
}
