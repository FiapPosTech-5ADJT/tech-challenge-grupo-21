package com.fiap.processorapi.application.usecase.contato.retrieve.get;

import com.fiap.processorapi.application.domain.contato.ContatoId;
import com.fiap.processorapi.application.exceptions.NotFoundException;
import com.fiap.processorapi.application.repositories.ContatoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultContatoGetByIdUseCase extends ContatoGetByIdUseCase {

  private final ContatoRepository contatoRepository;

  @Override
  public ContatoGetByIdUseCaseOutput execute(String input) {
    final var contatoId = ContatoId.from(input);

    return contatoRepository.findById(contatoId)
      .map(ContatoGetByIdUseCaseOutput::from)
      .orElseThrow(() -> new NotFoundException("Registro with ID %s not found.".formatted(contatoId)));
  }
}
