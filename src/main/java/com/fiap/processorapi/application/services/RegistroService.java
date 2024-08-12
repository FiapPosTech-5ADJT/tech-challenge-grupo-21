package com.fiap.processorapi.application.services;

import com.fiap.processorapi.application.domain.registro.Registro;
import com.fiap.processorapi.application.enums.Status;
import com.fiap.processorapi.application.repositories.RegistroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistroService {

    private final RegistroRepository registroRepository;

    public List<Registro> buscarRegistrosPendentes() {
        return registroRepository.findByStatus(Status.PENDENTE);
    }

    public void atualizarStatusParaProcessado(Registro registro) {
        atualizarRegistroStatus(Status.CONCLUIDO, registro);
    }

    public void atualizarStatusParaExpirado(Registro registro) {
        atualizarRegistroStatus(Status.CANCELADO, registro);
    }

    private void atualizarRegistroStatus(Status status, Registro registro) {
        registro.setStatusEnum(status);
        registro.setDataProcessamento(Instant.now());
        registroRepository.updateStatus(registro);
    }

    public void atualizarQntTentativas(Registro registro) {
        registro.setNumTentativas(registro.getNumTentativas() + 1);
        registroRepository.updateNumTentativas(registro);
    }
}
