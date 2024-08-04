package com.fiap.processorapi.application.domain.contato;

import java.time.Instant;
import java.util.Objects;

public class Contato {
  private ContatoId id;
  private String nome;
  private String email;
  private String telefone;
  private Instant createdAt;
  private Instant updatedAt;
  private Instant deletedAt;

  public Contato(final ContatoId id, final String nome, final String email, final String telefone, final Instant createdAt,
      final Instant updatedAt, final Instant deletedAt) {
    this.id = Objects.requireNonNull(id, "id cannot be null");
    this.nome = nome;
    this.email = email;
    this.telefone = telefone;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.deletedAt = deletedAt;
  }

  public static Contato newContato(final String nome, final String email, final String telefone) {
    final var id = ContatoId.generate();
    final var now = Instant.now();
    final var deletedAt = false ? null : now;
    return new Contato(id, nome, email, telefone, now, now, deletedAt);
  }

}
