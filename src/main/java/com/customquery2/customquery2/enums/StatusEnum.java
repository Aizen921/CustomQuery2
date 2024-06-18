package com.customquery2.customquery2.enums;

public enum StatusEnum {
    ONTIME("on time"),

    DELAYED("delayed"),

    CANCELLED("cancelled");

    private String statusEnum;

    StatusEnum(String statusEnum) {
        this.statusEnum = statusEnum;
    }

    StatusEnum() {
    }

    public String getStatusEnum() {
        return statusEnum;
    }

    public void setStatusEnum(String statusEnum) {
        this.statusEnum = statusEnum;
    }
}
