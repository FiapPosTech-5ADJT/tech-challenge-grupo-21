package com.fiap.processorapi.infrastructure.api;

import com.fiap.processorapi.application.usecase.registro.create.RegistroCreateUseCase;
import com.fiap.processorapi.application.usecase.registro.retrieve.list.RegistroListUseCase;
import com.fiap.processorapi.infrastructure.mappers.RegistroMapper;
import com.fiap.processorapi.registros.api.RegistrosApi;
import com.fiap.processorapi.registros.model.CriarRegistroDTO;
import com.fiap.processorapi.registros.model.RegistroDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class RegistroController implements RegistrosApi {

  private final RegistroCreateUseCase registroCreateUseCase;
  private final RegistroListUseCase registroListUseCase;
  private final RegistroMapper registroMapper;

  @Override
  public ResponseEntity<RegistroDTO> criarRegistro(CriarRegistroDTO body) {
    final var useCaseInput = registroMapper.fromDTO(body);
    final var useCaseOutput = registroCreateUseCase.execute(useCaseInput);
    return ResponseEntity.ok(registroMapper.toDTO(useCaseOutput));
  }

  @Override
  public ResponseEntity<List<RegistroDTO>> listaRegistros() {
    final var output = registroListUseCase.execute();
    return ResponseEntity.ok(registroMapper.toDTO(output));
  }
}
