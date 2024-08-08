package com.fiap.processorapi.application.usecase.registro.create;

import com.fiap.processorapi.application.enums.Status;

public record RegistroCreateInput( String idCredenciamento,  String numeroDocumento,  String tipoPessoa,
                                   Status status,  String payloadCredenciamento
                                 ) {
}
