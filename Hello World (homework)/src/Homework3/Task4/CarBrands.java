package Homework3.Task4;

public enum CarBrands {
    AUDI("Audi"),
    BMW("BMW"),
    KIA("KIA");

    final String name;
    static final String[] audiColors = {"синий", "красный", "зеленый"};
    static final String[] bmwColors = {"оранжевый", "чёрный", "фиолетовый"};
    static final String[] kiaColors = {"жёлтый", "серый", "белый"};

    CarBrands(String name) {
        this.name = name;
    }


}
