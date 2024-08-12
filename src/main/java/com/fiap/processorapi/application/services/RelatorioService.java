package com.fiap.processorapi.application.services;

import com.fiap.processorapi.application.domain.contato.Contato;
import com.fiap.processorapi.application.domain.credenciamento.RelatorioDTO;
import com.fiap.processorapi.application.domain.registro.Registro;
import com.fiap.processorapi.application.enums.Status;
import com.fiap.processorapi.application.enums.StatusCredenciamento;
import com.fiap.processorapi.application.repositories.ContatoRepository;
import com.fiap.processorapi.application.repositories.CredenciamentoRepository;
import com.fiap.processorapi.application.repositories.RegistroRepository;
import com.fiap.processorapi.infrastructure.persistence.entities.CredenciamentoJPAEntity;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RelatorioService {

    private static final Logger logger = LoggerFactory.getLogger(RelatorioService.class);

    private final RegistroRepository registroRepository;
    private final CredenciamentoRepository credenciamentoRepository;
    private final ContatoRepository contatoRepository;
    private final JavaMailSender mailSender;

    public void enviarRelatorioPorEmail(Status status) throws MessagingException {
      logger.info("Iniciando envio de relatório por email para status: {}", status);
      try {
        // Descomentar as linhas abaixo para obter relatorio do dia anterior
        // Instant dataInicio = LocalDate.now().minusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant();
        // Instant dataFim = LocalDate.now().minusDays(1).atTime(23, 59, 59).atZone(ZoneId.systemDefault()).toInstant();

        // Descomentar as linhas abaixo para obter relatorio do dia atual
        Instant dataInicio = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
        Instant dataFim = LocalDate.now().atTime(23, 59, 59).atZone(ZoneId.systemDefault()).toInstant();

        String dataRelatorioFormatada = formatarDataRelatorio(dataInicio);

        List<RelatorioDTO> relatorio = gerarRelatorio(status, dataInicio, dataFim);

        List<Contato> contatos = contatoRepository.findAll();

        String emailContent = formatarRelatorio(relatorio);

        for (Contato contato : contatos) {
          enviarEmail(contato.getEmail(), "Relatório de Processamento - " + dataRelatorioFormatada, emailContent);
        }
        logger.info("Relatório enviado com sucesso para {} contatos.", contatos.size());
      } catch (Exception e) {
        logger.error("Erro ao enviar relatório por email", e);
        throw e;
      }
    }

    public List<RelatorioDTO> gerarRelatorio(Status status, Instant inicioDiaData, Instant fimDiaData) {
      logger.info("Gerando relatório para status: {}", status);

      List<Registro> registros = registroRepository.findByStatusAndDataProcessamentoBetween(status.getValue(), inicioDiaData, fimDiaData);

      logger.info("Número de registros encontrados: {}", registros.size());

      return registros.stream().map(registro -> {
        CredenciamentoJPAEntity credenciamento = credenciamentoRepository.findByNumeroDocumento(registro.getNumeroDocumento())
          .orElseThrow(() -> {
            logger.error("Credenciamento não encontrado para o documento: {}", registro.getNumeroDocumento());
            return new RuntimeException("Credenciamento não encontrado para o documento: " + registro.getNumeroDocumento());
          });
        return new RelatorioDTO(
          registro.getDataProcessamento(),
          registro.getNumeroDocumento(),
          registro.getTipoPessoa(),
          registro.getStatus(),
          StatusCredenciamento.fromValue(credenciamento.getStatus()),
          credenciamento.getNumeroPontoVenda()
        );
      }).collect(Collectors.toList());
    }

    private String formatarRelatorio(List<RelatorioDTO> relatorio) {
      StringBuilder emailContent = new StringBuilder();
      emailContent.append("<html><body>");
      emailContent.append("<h1>Relatório de Processamento</h1>");
      int contador = 1;
      for (RelatorioDTO item : relatorio) {
        emailContent.append("<h2>Item ").append(contador).append("</h2>")
          .append("<p><strong>Data de Processamento:</strong> ").append(formatarDataProcessamento(item.getDataProcessamento())).append("</p>")
          .append("<p><strong>Número do Documento:</strong> ").append(item.getNumeroDocumento()).append("</p>")
          .append("<p><strong>Tipo de Pessoa:</strong> ").append(item.getTipoPessoa()).append("</p>")
          .append("<p><strong>Status do Registro:</strong> ").append(item.getStatusRegistro()).append("</p>")
          .append("<p><strong>Status do Credenciamento:</strong> ").append(item.getStatusCredenciamento()).append("</p>")
          .append("<p><strong>Número do Ponto de Venda:</strong> ").append(item.getNumeroPontoVenda()).append("</p>")
          .append("<hr>");
        contador++;
      }
      emailContent.append("</body></html>");
      return emailContent.toString();
    }

    private void enviarEmail(String to, String subject, String content) throws MessagingException {
      logger.info("Enviando email para: {}", to);
      MimeMessage message = mailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(message, true);
      helper.setTo(to);
      helper.setSubject(subject);
      helper.setText(content, true); // true para HTML
      mailSender.send(message);
      logger.info("Email enviado para: {}", to);
    }

    private String formatarDataRelatorio(Instant dataRelatorio) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy").withZone(ZoneId.systemDefault());
      return formatter.format(dataRelatorio);
    }

    private String formatarDataProcessamento(Instant dataProcessamento) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:MM").withZone(ZoneId.systemDefault());
      return formatter.format(dataProcessamento);
    }
}
