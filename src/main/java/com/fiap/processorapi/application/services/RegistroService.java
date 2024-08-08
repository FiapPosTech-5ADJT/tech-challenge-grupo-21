package com.fiap.processorapi.application.services;

import com.fiap.processorapi.application.domain.registro.Registro;
import com.fiap.processorapi.application.enums.Status;
import com.fiap.processorapi.application.repositories.RegistroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistroService {

    private final RegistroRepository registroRepository;

    public List<Registro> buscarRegistrosPendentes() {
        return registroRepository.findByStatus(Status.PENDENTE);
    }

    public void atualizarStatusParaProcessado(Registro registro) {
      registro.setStatusEnum(Status.CONCLUIDO);
      registroRepository.updateStatus(registro);
    }


}
