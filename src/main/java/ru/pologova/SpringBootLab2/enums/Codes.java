package ru.pologova.SpringBootLab2.enums;

public enum Codes {

    SUCCESS("success"),
    FAILED("failed");

    private final String value;

    Codes(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}