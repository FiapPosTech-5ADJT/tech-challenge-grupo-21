package com.fiap.processorapi.application.usecase.contato.retrieve.list;

import com.fiap.processorapi.application.repositories.ContatoRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class DefaultListContatoUseCase extends ContatoListUseCase {

  private final ContatoRepository  contatoRepository;

  @Override
  public List<ContatoListOutput> execute() {
    return contatoRepository.findAll().stream()
            .map(ContatoListOutput::from)
            .toList();
  }
}
