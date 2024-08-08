package com.fiap.processorapi.application.usecase.registro.update;

import com.fiap.processorapi.application.domain.registro.RegistroId;
import com.fiap.processorapi.application.repositories.RegistroRepository;
import com.fiap.processorapi.application.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultRegistroUpdateUseCase  extends RegistroUpdateUseCase{
  private final RegistroRepository registroRepository;

  @Override
  public RegistroUpdateUseCaseOutput execute(RegistroUpdateUseCaseInput input) {
    final var registroId = RegistroId.from(input.id());

    final var registro = registroRepository.findById(registroId)
      .orElseThrow(() -> new NotFoundException("Registro with ID %s not found.".formatted(registroId)));

    registro.updateRegistro(input.idCredenciamento(), input.numeroDocumento(), input.tipoPessoa(), input.status(), input.dataProcessamento(), input.payloadCredenciamento(), input.numTentativas());

    this.registroRepository.update(registro);

    return RegistroUpdateUseCaseOutput.from(registro);

  }
}
