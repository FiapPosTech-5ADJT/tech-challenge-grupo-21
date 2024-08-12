package com.fiap.processorapi.infrastructure.api;

import com.fiap.processorapi.application.usecase.contato.retrieve.list.ContatoListUseCase;
import com.fiap.processorapi.contatos.api.ContatosApi;
import com.fiap.processorapi.contatos.model.ContatoDTO;
import com.fiap.processorapi.infrastructure.mappers.ContatoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ContatoController implements ContatosApi {

  private final ContatoListUseCase contatoListUseCase;

  private final ContatoMapper contatoMapper;

  @Override
  public ResponseEntity<List<ContatoDTO>> listaContatos() {
      final var output = contatoListUseCase.execute();
      return ResponseEntity.ok(contatoMapper.toDTO(output));
  }
}
