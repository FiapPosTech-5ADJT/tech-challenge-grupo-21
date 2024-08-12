package com.fiap.processorapi.application.usecase.contato.update;

import com.fiap.processorapi.application.domain.contato.ContatoId;
import com.fiap.processorapi.application.exceptions.NotFoundException;
import com.fiap.processorapi.application.repositories.ContatoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultContatoUpdateUseCase  extends ContatoUpdateUseCase {
  private final ContatoRepository contatoRepository;

  @Override
  public ContatoUpdateUseCaseOutput execute(ContatoUpdateUseCaseInput input) {
    final var contatoId = ContatoId.from(input.id());

    final var contato = contatoRepository.findById(contatoId)
      .orElseThrow(() -> new NotFoundException("Contato with ID %s not found.".formatted(contatoId)));

    contato.updateContato(input.nome(), input.email(), input.telefone());

    this.contatoRepository.update(contato);

    return ContatoUpdateUseCaseOutput.from(contato);

  }
}
