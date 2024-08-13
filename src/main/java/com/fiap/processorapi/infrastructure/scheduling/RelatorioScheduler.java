package com.fiap.processorapi.infrastructure.scheduling;

import com.fiap.processorapi.application.enums.Status;
import com.fiap.processorapi.application.services.RelatorioService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

@Component
@RequiredArgsConstructor
public class RelatorioScheduler {

    private static final Logger logger = LoggerFactory.getLogger(RegistroScheduler.class);

    private final RelatorioService relatorioService;

    @Scheduled(cron = "0 0 7 * * ?") // Todos os dias às 7 da manhã
    //@Scheduled(cron = "0 55 11 * * ?") // Data personalizada
    public void enviarRelatorioDiario() {
        Instant dataProcessamento = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
        try {
            relatorioService.enviarRelatorioPorEmail(Status.CONCLUIDO);
            logger.info("Relatório diário enviado com sucesso.");
        } catch (MessagingException e) {
            logger.error("Erro ao enviar relatório diário por email", e);
        }
    }
}
