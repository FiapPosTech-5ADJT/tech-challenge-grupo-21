package com.fiap.processorapi.application.domain.registro;

import com.fiap.processorapi.application.enums.Status;

import java.time.Instant;
import java.util.Objects;

public class Registro {
  private RegistroId id;
  private String idCredenciamento;
  private String numeroDocumento;
  private String tipoPessoa;
  private Status status;
  private String payloadCredenciamento;
  private Instant dataProcessamento;
  private int numTentativas;
  private Instant createdAt;
  private Instant updatedAt;
  private Instant deletedAt;

  public Registro(final RegistroId id, final String idCredenciamento, final String numeroDocumento, final String tipoPessoa,
      final Status status, final String payloadCredenciamento, final Instant dataProcessamento, final int numTentativas,
      final Instant createdAt, final Instant updatedAt, final Instant deletedAt) {
    this.id = Objects.requireNonNull(id, "id cannot be null");
    this.idCredenciamento = idCredenciamento;
    this.numeroDocumento = numeroDocumento;
    this.tipoPessoa = tipoPessoa;
    this.status = status;
    this.payloadCredenciamento = payloadCredenciamento;
    this.dataProcessamento = dataProcessamento;
    this.numTentativas = numTentativas;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.deletedAt = deletedAt;
  }

  public int getStatusValue() {
    return status.getValue();
  }

  public void setStatusFromValue(int value) {
    this.status = Status.fromValue(value);
  }
}
