package com.fiap.processorapi.application.usecase.registro.retrieve.get;

import com.fiap.processorapi.application.domain.registro.RegistroId;
import com.fiap.processorapi.application.exceptions.NotFoundException;
import com.fiap.processorapi.application.repositories.RegistroRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultRegistroGetByIdUseCase extends RegistroGetByIdUseCase {

  private final RegistroRepository registroRepository;

  @Override
  public RegistroGetByIdUseCaseOutput execute(String input) {
    final var registroId = RegistroId.from(input);

    return registroRepository.findById(registroId)
      .map(RegistroGetByIdUseCaseOutput::from)
      .orElseThrow(() -> new NotFoundException("Registro with ID %s not found.".formatted(registroId)));
  }
}
