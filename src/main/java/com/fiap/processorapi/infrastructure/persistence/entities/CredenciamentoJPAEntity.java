package com.fiap.processorapi.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "credenciamentos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class CredenciamentoJPAEntity {

    @Id
    @Column(name = "id", nullable = false, unique = true, length = 36)
    private UUID id;

    @Column(name = "id_credenciamento", nullable = false, length = 40)
    private String idCredenciamento;

    @Column(name = "numero_documento", nullable = false)
    private String numeroDocumento;

    @Column(name = "tipo_pessoa", nullable = false, length = 1)
    private String tipoPessoa;

    @Column(name = "status", nullable = false, length = 10)
    private int status;

    @Column(name = "numero_ponto_venda")
    private Long numeroPontoVenda;

    @Column(name = "numero_solicitacao", nullable = false)
    private Long numeroSolicitacao;

    @Column(name = "data_credenciamento", nullable = false)
    private Instant dataCredenciamento;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;
}
