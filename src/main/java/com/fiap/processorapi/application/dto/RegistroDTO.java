package com.fiap.processorapi.application.dto;

import com.fiap.processorapi.application.enums.Status;

import java.time.Instant;
import java.util.UUID;

public record RegistroDTO(UUID id,
                          String idCredenciamento,
                          String numeroDocumento,
                          String tipoPessoa,
                          Status status,
                          String payloadCredenciamento,
                          Instant dataProcessamento,
                          int numTentativas,
                          Instant createdAt,
                          Instant updatedAt,
                          Instant deletedAt) {
}
