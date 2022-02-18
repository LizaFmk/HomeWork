package Homework4;

public enum Models {
    CX5("CX-5"),
    CX7("CX-7"),
    CX9("CX-9"),
    ;

    private String name;

    Models(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
