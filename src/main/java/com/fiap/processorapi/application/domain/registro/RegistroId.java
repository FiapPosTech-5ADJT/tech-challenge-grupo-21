package com.fiap.processorapi.application.domain.registro;

import java.util.UUID;

public record RegistroId(String value) {

  public RegistroId {
        if (value == null) {
            throw new IllegalArgumentException("Registro id cannot be null");
        }
    }

    public static RegistroId generate() {
        return new RegistroId(UUID.randomUUID().toString());
    }

    public static RegistroId from(final String value) {
        try {
            return new RegistroId(UUID.fromString(value).toString());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid registro id");
        }
    }

    @Override
    public String toString() {
        return value;
    }

}
