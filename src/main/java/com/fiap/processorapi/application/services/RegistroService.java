package com.fiap.processorapi.application.services;

import com.fiap.processorapi.application.domain.registro.Registro;
import com.fiap.processorapi.application.dto.RegistroDTO;
import com.fiap.processorapi.application.enums.Status;
import com.fiap.processorapi.application.repositories.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class RegistroService {
    @Autowired
    private RegistroRepository registroRepository;

    public Collection<RegistroDTO> findPendentRecords() {
        var registros = registroRepository.findByStatus(Status.PENDENT);
        return registros.stream().map(this::toRegistroDTO).collect(Collectors.toList());
    }

    private RegistroDTO toRegistroDTO(Registro registro) {
        return new RegistroDTO(registro.getId(),
                registro.getIdCredenciamento(),
                registro.getNumeroDocumento(),
                registro.getTipoPessoa(),
                registro.getStatus(),
                registro.getPayloadCredenciamento(),
                registro.getDataProcessamento(),
                registro.getNumTentativas(),
                registro.getCreatedAt(),
                registro.getUpdatedAt(),
                registro.getDeletedAt());
    }
}
