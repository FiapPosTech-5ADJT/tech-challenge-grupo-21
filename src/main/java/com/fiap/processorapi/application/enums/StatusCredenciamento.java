package com.fiap.processorapi.application.enums;

import java.util.Random;

public enum StatusCredenciamento {
  CREDENCIADO(1),
  ALCADA_DE_RISCO(2),
  REPROVADO_PLD(3),
  OUTRO(4);

  private final int value;
  private static final Random RANDOM = new Random();

  StatusCredenciamento(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public static StatusCredenciamento getRandomStatus() {
    StatusCredenciamento[] statuses = values();
    return statuses[RANDOM.nextInt(statuses.length)];
  }

  public static StatusCredenciamento fromValue(int value) {
    for (StatusCredenciamento status : StatusCredenciamento.values()) {
      if (status.value == value) {
        return status;
      }
    }
    throw new IllegalArgumentException("Invalid status value: " + value);
  }
}
