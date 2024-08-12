package com.fiap.processorapi.application.usecase.contato.retrieve.get;

import com.fiap.processorapi.application.domain.contato.Contato;
import com.fiap.processorapi.application.domain.contato.ContatoId;

import java.time.Instant;

public record ContatoGetByIdUseCaseOutput (ContatoId id, String nome, String email, String telefone, Instant createdAt, Instant updatedAt,
                                           Instant deletedAt) {

  public static ContatoGetByIdUseCaseOutput from(Contato contato){
    return new ContatoGetByIdUseCaseOutput(contato.getId(), contato.getNome(), contato.getEmail(), contato.getTelefone(),
            contato.getCreatedAt(), contato.getUpdatedAt(), contato.getDeletedAt());
  }
}
