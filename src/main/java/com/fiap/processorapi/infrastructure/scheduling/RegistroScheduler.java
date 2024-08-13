package com.fiap.processorapi.infrastructure.scheduling;

import com.fiap.processorapi.application.domain.registro.Registro;
import com.fiap.processorapi.application.services.RegistroService;
import com.fiap.processorapi.infrastructure.externalApi.Suc;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RegistroScheduler {

    private static final Logger logger = LoggerFactory.getLogger(RegistroScheduler.class);

    private final RegistroService registroService;

    private final Suc suc;

    @Scheduled(fixedRate = 300000, initialDelay = 300000) // 5 minutos em milissegundos
    public void executarBuscaRegistrosPendentes() {
        var registrosPendentes = registroService.buscarRegistrosPendentes();
        logger.info("Registros pendentes: {}", registrosPendentes.size());
        for (Registro registro : registrosPendentes) {
            if (registro.getNumTentativas() >= 5) {
                registroService.atualizarStatusParaExpirado(registro);
                return;
            }
            String retorno = this.sendSucData(registro);
            if ("Success".equals(retorno)) {
                registroService.atualizarStatusParaProcessado(registro);
                return;
            } else {
                registroService.atualizarQntTentativas(registro);
            }
        }
    }
    private String sendSucData(final Registro registro) {
        return suc.sendSucData(registro);
    }
}
