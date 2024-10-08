package com.fiap.processorapi.application.domain.contato;

import java.util.UUID;

public record ContatoId(String value) {

  public ContatoId {
    if (value == null) {
      throw new IllegalArgumentException("Contato id cannot be null");
    }
  }

  public static ContatoId generate() {
    return new ContatoId(UUID.randomUUID().toString());
  }

  public static ContatoId from(final String value) {
    try {
      return new ContatoId(UUID.fromString(value).toString());
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Invalid contato id");
    }
  }

  @Override
  public String toString() {
    return value;
  }

}
