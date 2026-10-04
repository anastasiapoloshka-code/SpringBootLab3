package ru.pologova.SpringBootLab2.enums;

public enum ErrorMessages {

    EMPTY(""),
    UNSUPPORTED_CODE("Не поддерживаемая ошибка"),
    VALIDATION_ERROR("Ошибка валидации"),
    UNKNOWN_ERROR("Произошла непредвиденная ошибка");

    private final String value;

    ErrorMessages(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}