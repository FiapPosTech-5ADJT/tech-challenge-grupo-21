package com.fiap.processorapi.application.usecase.registro.create;

import com.fiap.processorapi.application.domain.registro.Registro;
import com.fiap.processorapi.application.domain.registro.RegistroId;
import com.fiap.processorapi.application.enums.Status;

import java.time.Instant;

public record RegistroCreateOutput( RegistroId id, String idCredenciamento, String numeroDocumento,  String tipoPessoa,
                                    Status status, String payloadCredenciamento, Instant dataProcessamento, int numTentativas,
                                    Instant createdAt, Instant updatedAt, Instant deletedAt) {

  public static RegistroCreateOutput from(final Registro registro) {
    return new RegistroCreateOutput(registro.getId(), registro.getIdCredenciamento(), registro.getNumeroDocumento(),
        registro.getTipoPessoa(), registro.getStatus(), registro.getPayloadCredenciamento(), registro.getDataProcessamento(),
        registro.getNumTentativas(), registro.getCreatedAt(), registro.getUpdatedAt(), registro.getDeletedAt());
  }
}
