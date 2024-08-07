package com.fiap.processorapi.application.usecase.registro.retrieve.list;

import com.fiap.processorapi.application.repositories.RegistroRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class DefaultListRegistroUseCase extends RegistroListUseCase {

  private final RegistroRepository registroRepository;

  @Override
  public List<RegistroListOutput> execute() {
    return registroRepository.findAll().stream()
            .map(RegistroListOutput::from)
            .toList();
  }
}
