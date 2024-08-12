package com.fiap.processorapi.application.domain.credenciamento;

import com.fiap.processorapi.application.enums.Status;
import com.fiap.processorapi.application.enums.StatusCredenciamento;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class RelatorioDTO {
    private Instant dataProcessamento;
    private String numeroDocumento;
    private String tipoPessoa;
    private Status statusRegistro;
    private StatusCredenciamento statusCredenciamento;
    private Long numeroPontoVenda;
}
