package com.fiap.processorapi.application.usecase.contato.retrieve.list;

import com.fiap.processorapi.application.domain.contato.Contato;
import com.fiap.processorapi.application.domain.contato.ContatoId;

import java.time.Instant;

public record ContatoListOutput(ContatoId id, String nome, String email, String telefone, Instant createdAt, Instant updatedAt,
                                 Instant deletedAt) {

  public static ContatoListOutput from(final Contato contato) {
    return new ContatoListOutput(contato.getId(), contato.getNome(), contato.getEmail(), contato.getTelefone(),
            contato.getCreatedAt(), contato.getUpdatedAt(), contato.getDeletedAt());
  }
}
