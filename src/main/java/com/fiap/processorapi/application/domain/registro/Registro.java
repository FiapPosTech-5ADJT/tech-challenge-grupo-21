package com.fiap.processorapi.application.domain.registro;

import com.fiap.processorapi.application.enums.Status;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "registro")
public class Registro {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private String idCredenciamento;
  private String numeroDocumento;
  private String tipoPessoa;
  @Enumerated(EnumType.ORDINAL)
  private Status status;
  private String payloadCredenciamento;
  private Instant dataProcessamento;
  private int numTentativas;
  private Instant createdAt;
  private Instant updatedAt;
  private Instant deletedAt;

  public Registro() {}

  public Registro(final UUID id, final String idCredenciamento, final String numeroDocumento, final String tipoPessoa,
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

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getIdCredenciamento() {
    return idCredenciamento;
  }

  public void setIdCredenciamento(String idCredenciamento) {
    this.idCredenciamento = idCredenciamento;
  }

  public String getNumeroDocumento() {
    return numeroDocumento;
  }

  public void setNumeroDocumento(String numeroDocumento) {
    this.numeroDocumento = numeroDocumento;
  }

  public String getTipoPessoa() {
    return tipoPessoa;
  }

  public void setTipoPessoa(String tipoPessoa) {
    this.tipoPessoa = tipoPessoa;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public String getPayloadCredenciamento() {
    return payloadCredenciamento;
  }

  public void setPayloadCredenciamento(String payloadCredenciamento) {
    this.payloadCredenciamento = payloadCredenciamento;
  }

  public Instant getDataProcessamento() {
    return dataProcessamento;
  }

  public void setDataProcessamento(Instant dataProcessamento) {
    this.dataProcessamento = dataProcessamento;
  }

  public int getNumTentativas() {
    return numTentativas;
  }

  public void setNumTentativas(int numTentativas) {
    this.numTentativas = numTentativas;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Instant getDeletedAt() {
    return deletedAt;
  }

  public void setDeletedAt(Instant deletedAt) {
    this.deletedAt = deletedAt;
  }
}
