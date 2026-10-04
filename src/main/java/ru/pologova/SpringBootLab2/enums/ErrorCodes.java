package ru.pologova.SpringBootLab2.enums;

public enum ErrorCodes {

    EMPTY(""),
    UNSUPPORTED_CODE_EXCEPTION("UnsupportedCodeException"),
    VALIDATION_EXCEPTION("ValidationException"),
    UNKNOWN_EXCEPTION("UnknownException");

    private final String value;

    ErrorCodes(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}