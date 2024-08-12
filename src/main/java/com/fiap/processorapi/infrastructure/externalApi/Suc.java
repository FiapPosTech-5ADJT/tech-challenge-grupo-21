package com.fiap.processorapi.infrastructure.externalApi;

import com.fiap.processorapi.application.domain.registro.Registro;
import com.fiap.processorapi.application.enums.StatusCredenciamento;
import com.fiap.processorapi.application.repositories.CredenciamentoRepository;
import com.fiap.processorapi.infrastructure.persistence.entities.CredenciamentoJPAEntity;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.time.Instant;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
@Service
@RequiredArgsConstructor
public class Suc {
  private static final Logger logger = LoggerFactory.getLogger(Suc.class);

  private final CredenciamentoRepository credenciamentoRepository;

  public String sendSucData(final Registro registro) {
        // Simula um comportamento aleatório para a resposta da API
        final String payload = registro.getPayloadCredenciamento();
        final String retornoSUC = callSucApi(payload);

        //Simula um comportamento de insert que é de reponsabilidade da API externa SUC
        if ("Success".equals(retornoSUC)) {
          insertCredenciamento(registro);
        }
        return  retornoSUC;

    }

  private String callSucApi(String payload) {
    final Random random = new Random();
    final int chance = random.nextInt(100);
    // Simula um delay de resposta da API
    try {
      TimeUnit.MILLISECONDS.sleep(500 + random.nextInt(500)); // Delay entre 500ms e 1000ms
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      logger.error("Thread interrupted", e);
      return "Failure";
    }

    // Log do payload enviado
    logger.info("Enviando payload para Suc API: {}", payload);

    try {
      HttpClient client = HttpClient.newHttpClient();
      HttpRequest request = HttpRequest.newBuilder()
        .uri(new URI("https://ficticia-api.com/suc"))
        .header("Content-Type", "application/json")
        .POST(HttpRequest.BodyPublishers.ofString(payload))
        .build();

      //HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

      // Simula a resposta da API com status randômico
      if (chance < 80) {  // 80% de chance de sucesso
        logger.info("Suc API response: Success");
        return "Success";
      } else {
        logger.info("Suc API response: Failure");
        return "Failure";
      }
    } catch (Exception e) {
      logger.error("Erro ao enviar request para Suc API", e);
      return "Failure";
    }
  }
  private void insertCredenciamento(Registro registro) {
    CredenciamentoJPAEntity credenciamento = new CredenciamentoJPAEntity();
    credenciamento.setId(UUID.randomUUID());
    credenciamento.setIdCredenciamento(registro.getIdCredenciamento());
    credenciamento.setNumeroDocumento(registro.getNumeroDocumento());
    credenciamento.setTipoPessoa(registro.getTipoPessoa());
    credenciamento.setStatus(StatusCredenciamento.getRandomStatus().getValue()); // getRandomStatus para definir os possiveis status do credenciamento (CREDENCIADO,ALCADA_DE_RISCO,REPROVADO_PLD,OUTRO)
    credenciamento.setNumeroPontoVenda(generateUniqueNumeroPontoVenda());
    credenciamento.setNumeroSolicitacao(generateUniqueNumeroSolicitacao());
    credenciamento.setDataCredenciamento(Instant.now());
    credenciamento.setCreatedAt(Instant.now());
    credenciamento.setUpdatedAt(Instant.now());

    credenciamentoRepository.save(credenciamento);
  }

  private Long generateUniqueNumeroPontoVenda() {
    // Implementação para gerar um valor único para numeroPontoVenda
    return System.currentTimeMillis();
  }

  private Long generateUniqueNumeroSolicitacao() {
    // Implementação para gerar um valor único para numeroSolicitacao
    return System.nanoTime();
  }
}
