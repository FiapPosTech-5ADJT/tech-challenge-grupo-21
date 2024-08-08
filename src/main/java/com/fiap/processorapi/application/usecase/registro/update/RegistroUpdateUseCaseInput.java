package com.fiap.processorapi.application.usecase.registro.update;

import com.fiap.processorapi.application.enums.Status;

import java.time.Instant;

public record RegistroUpdateUseCaseInput(String id, String idCredenciamento, String numeroDocumento, String tipoPessoa,
                                         Status status, Instant dataProcessamento, String payloadCredenciamento, int numTentativas){
}
