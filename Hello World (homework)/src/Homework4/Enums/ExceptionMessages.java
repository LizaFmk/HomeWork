package Homework4.Enums;

public enum ExceptionMessages {
    NULL_POINTER_EXCEPTION_MESSAGE("Нет машины (null)"),
    CLASS_CAST_EXCEPTION_MESSAGE("Невозможно собрать автомобиль: несовместимый набор параметров"),
    ILLEGAL_ARGUMENT_EXCEPTION_MESSAGE("Невозможно собрать автомобиль: неверные параметры"),
    ;

    private String text;

    ExceptionMessages(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
