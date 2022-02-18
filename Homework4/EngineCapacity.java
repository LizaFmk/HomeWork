package Homework4;

public enum EngineCapacity {
    T1800("1.8"),
    T2000("2.0"),
    T2300("2.3"),
    ;

    private String name;

    EngineCapacity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
