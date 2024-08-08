package com.fiap.processorapi.application.usecase;

import com.fiap.processorapi.application.domain.registro.Registro;
import com.fiap.processorapi.application.repositories.RegistroRepository;
import com.fiap.processorapi.application.usecase.registro.create.RegistroCreateInput;
import com.fiap.processorapi.application.usecase.registro.create.RegistroCreateOutput;
import com.fiap.processorapi.application.usecase.registro.create.RegistroCreateUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultRegistroUseCase extends RegistroCreateUseCase  {

  private final RegistroRepository registroRepository;

  @Override
  public RegistroCreateOutput execute(RegistroCreateInput input) {
    final var newRegistro = Registro.newRegistro(input.idCredenciamento(), input.numeroDocumento(), input.tipoPessoa(), input.payloadCredenciamento());
    final var createRegistro = registroRepository.create(newRegistro);
    return  RegistroCreateOutput.from(createRegistro);
  }
}
