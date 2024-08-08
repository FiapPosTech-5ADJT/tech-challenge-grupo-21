package com.fiap.processorapi.application.usecase;

public abstract class UnitUseCase<IN> {

  public abstract void execute(IN input);
}
