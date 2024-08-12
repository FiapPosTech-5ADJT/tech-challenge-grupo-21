package com.fiap.processorapi.application.usecase.contato.create;

import com.fiap.processorapi.application.domain.contato.Contato;
import com.fiap.processorapi.application.domain.contato.ContatoId;

import java.time.Instant;

public record ContatoCreateOutput(ContatoId id, String nome, String email, String telefone, Instant createdAt, Instant updatedAt,
    Instant deletedAt) {

  public static ContatoCreateOutput from(final Contato contato) {
    return new ContatoCreateOutput(contato.getId(), contato.getNome(), contato.getEmail(), contato.getTelefone(),
        contato.getCreatedAt(), contato.getUpdatedAt(), contato.getDeletedAt());
  }
}
