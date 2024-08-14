package com.fiap.processorapi.infrastructure.api;

import com.fiap.processorapi.application.exceptions.NotFoundException;
import com.fiap.processorapi.application.usecase.contato.create.ContatoCreateUseCase;
import com.fiap.processorapi.application.usecase.contato.delete.ContatoDeleteUseCase;
import com.fiap.processorapi.application.usecase.contato.retrieve.get.ContatoGetByIdUseCase;
import com.fiap.processorapi.application.usecase.contato.retrieve.list.ContatoListUseCase;
import com.fiap.processorapi.application.usecase.contato.update.ContatoUpdateUseCase;
import com.fiap.processorapi.application.usecase.registro.retrieve.get.RegistroGetByIdUseCase;
import com.fiap.processorapi.contatos.api.ContatosApi;
import com.fiap.processorapi.contatos.model.AtualizaContatoDTO;
import com.fiap.processorapi.contatos.model.ContatoDTO;
import com.fiap.processorapi.contatos.model.CriarContatoDTO;
import com.fiap.processorapi.infrastructure.mappers.ContatoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class ContatoController implements ContatosApi {

  private final ContatoListUseCase contatoListUseCase;
  private final ContatoCreateUseCase contatoCreateUseCase;
  private final ContatoDeleteUseCase contatoDeleteUseCase;
  private final ContatoGetByIdUseCase contatoGetByIdUseCase;
  private final ContatoUpdateUseCase contatoUpdateUseCase;

  private final ContatoMapper contatoMapper;

  @Override
  public ResponseEntity<List<ContatoDTO>> listaContatos() {
    final var output = contatoListUseCase.execute();
    return ResponseEntity.ok(contatoMapper.toDTO(output));
  }

  @Override
  public ResponseEntity<ContatoDTO> criarContato(CriarContatoDTO body) {
    final var useCaseInput = contatoMapper.fromDTO(body);
    final var useCaseOutput = contatoCreateUseCase.execute(useCaseInput);
    return ResponseEntity.ok(contatoMapper.toDTO(useCaseOutput));
  }

  @Override
  public ResponseEntity<Void> deletaContato(UUID contatoId) {
    contatoDeleteUseCase.execute(contatoId.toString());
    return ResponseEntity.noContent().build();
  }

  @Override
  public ResponseEntity<ContatoDTO> atualizarContato(UUID contatoId, AtualizaContatoDTO body) {
    final var input = contatoMapper.fromDTO(contatoId.toString(), body);
    final var output = contatoUpdateUseCase.execute(input);
    return ResponseEntity.ok(contatoMapper.toDTO(output));
  }

  @Override
  public ResponseEntity<ContatoDTO> obterContato(UUID contatoId) {
    try {
      final var output = contatoMapper.toDTO(contatoGetByIdUseCase.execute(contatoId.toString()));
      return ResponseEntity.ok(output);
    } catch (NotFoundException e) {
      return ResponseEntity.status(404).body(null);
    }
  }
}
