package fmi.web.backend.entity;

public enum PhoneType {
    WORK("WORK"), PERSONAL("PERSONAL"), HOME("HOME");
    private String type;
    private PhoneType(String type) {
        this.type = type;
    }
}
