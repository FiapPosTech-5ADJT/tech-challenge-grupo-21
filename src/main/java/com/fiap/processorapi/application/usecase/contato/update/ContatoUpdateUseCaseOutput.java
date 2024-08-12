package com.fiap.processorapi.application.usecase.contato.update;

import com.fiap.processorapi.application.domain.contato.Contato;
import com.fiap.processorapi.application.domain.contato.ContatoId;


import java.time.Instant;

public record ContatoUpdateUseCaseOutput (ContatoId id, String nome, String email, String telefone, Instant createdAt, Instant updatedAt,
                                           Instant deletedAt) {

  public static ContatoUpdateUseCaseOutput from(final Contato contato) {
    return new ContatoUpdateUseCaseOutput(contato.getId(), contato.getNome(), contato.getEmail(), contato.getTelefone(),
            contato.getCreatedAt(), contato.getUpdatedAt(), contato.getDeletedAt());
  }
}
