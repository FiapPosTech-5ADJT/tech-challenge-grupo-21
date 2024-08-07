package com.fiap.processorapi.application.usecase;

public  abstract class UseCase<IN, OUT> {

  public abstract OUT execute(IN input);
}
