package com.fiap.processorapi.infrastructure.scheduling;

import com.fiap.processorapi.application.domain.registro.Registro;
import com.fiap.processorapi.application.services.RegistroService;
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

    @Scheduled(fixedRate = 30000, initialDelay = 30000) // 5 minutos em milissegundos
    public void executarBuscaRegistrosPendentes() {
        var registrosPendentes = registroService.buscarRegistrosPendentes();
        logger.info("Registros pendentes: {}", registrosPendentes);
        // Adicione a lógica para processar os registros pendentes aqui
      /*  for (Registro registro : registrosPendentes) {
          //atualizar registro para processado
          registroService.atualizarStatusParaProcessado(registro);
        }*/
    }
}
