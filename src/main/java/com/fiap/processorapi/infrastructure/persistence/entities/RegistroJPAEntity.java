package com.fiap.processorapi.infrastructure.persistence.entities;

import com.fiap.processorapi.application.domain.registro.Registro;
import com.fiap.processorapi.application.domain.registro.RegistroId;
import com.fiap.processorapi.application.enums.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


import java.time.Instant;

@Entity
@Table(name = "registros")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class RegistroJPAEntity {

    @Id
    @Column(name = "id", nullable = false, unique = true, length = 36)
    private String id;

    @Column(name = "id_credenciamento", nullable = false, length = 40)
    private String idCredenciamento;

    @Column(name = "numero_documento", nullable = false)
    private Long numeroDocumento;

    @Column(name = "tipo_pessoa", nullable = false, length = 1)
    private String tipoPessoa;

    @Column(name = "status", nullable = false)
    private int status;

    @Column(name = "payload_credenciamento", nullable = false, length = 1000)
    private String payloadCredenciamento;

    @Column(name = "data_processamento")
    private Instant dataProcessamento;

    @Column(name = "num_tentativas", nullable = false)
    private int numTentativas;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    public static RegistroJPAEntity of(Registro registro) {
        return new RegistroJPAEntity(
                registro.getId().value(),
                registro.getIdCredenciamento(),
                Long.valueOf(registro.getNumeroDocumento()),
                registro.getTipoPessoa(),
                registro.getStatus().getValue(),
                registro.getPayloadCredenciamento(),
                registro.getDataProcessamento(),
                registro.getNumTentativas(),
                registro.getCreatedAt(),
                registro.getUpdatedAt(),
                registro.getDeletedAt()
        );
    }

    public Registro toRegistro() {
        return new Registro(
                RegistroId.from(id),
                idCredenciamento,
                String.valueOf(numeroDocumento),
                tipoPessoa,
                Status.fromValue(status),
                payloadCredenciamento,
                dataProcessamento,
                numTentativas,
                createdAt,
                updatedAt,
                deletedAt
        );
    }
}
