// Enum Status
package com.fiap.processorapi.application.enums;

public enum Status {
    PENDENTE(0),
    CONCLUIDO(1),
    ERR(2),
    CANCELADO(3);

    private final int value;

    Status(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Status fromValue(int value) {
        for (Status status : Status.values()) {
            if (status.value == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status value: " + value);
    }
}
