package com.fiap.processorapi.infrastructure.persistence.entities;

import com.fiap.processorapi.application.domain.contato.Contato;
import com.fiap.processorapi.application.domain.contato.ContatoId;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "contatos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class ContatoJPAEntity {

    @Id
    @Column(name = "id", nullable = false, unique = true, length = 36)
    private String id;

    @Column(name = "telefone", length = 15)
    private String telefone;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

  public Contato toContato() {
    return new Contato(ContatoId.from(id), nome, email, telefone, createdAt, updatedAt, deletedAt);
  }
}
