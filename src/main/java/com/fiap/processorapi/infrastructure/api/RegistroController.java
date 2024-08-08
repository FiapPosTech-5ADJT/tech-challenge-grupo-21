package com.fiap.processorapi.infrastructure.api;

import com.fiap.processorapi.application.exceptions.NotFoundException;
import com.fiap.processorapi.application.usecase.registro.create.RegistroCreateUseCase;
import com.fiap.processorapi.application.usecase.registro.delete.RegistroDeleteUseCase;
import com.fiap.processorapi.application.usecase.registro.retrieve.get.RegistroGetByIdUseCase;
import com.fiap.processorapi.application.usecase.registro.retrieve.list.RegistroListUseCase;
import com.fiap.processorapi.application.usecase.registro.update.RegistroUpdateUseCase;
import com.fiap.processorapi.infrastructure.mappers.RegistroMapper;
import com.fiap.processorapi.registros.api.RegistrosApi;
import com.fiap.processorapi.registros.model.AtualizaRegistroDTO;
import com.fiap.processorapi.registros.model.CriarRegistroDTO;
import com.fiap.processorapi.registros.model.RegistroDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
public class RegistroController implements RegistrosApi {

  private final RegistroCreateUseCase registroCreateUseCase;
  private final RegistroListUseCase registroListUseCase;
  private final RegistroGetByIdUseCase registroGetByIdUseCase;
  private final RegistroUpdateUseCase registroUpdateUseCase;
  private final RegistroDeleteUseCase registroDeleteUseCase;

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

  @Override
  public ResponseEntity<RegistroDTO> obterRegistro(UUID registroId) {
    try {
      final var output = registroMapper.toDTO(registroGetByIdUseCase.execute(registroId.toString()));
      return ResponseEntity.ok(output);
    } catch (NotFoundException e) {
      return ResponseEntity.status(404).body(null);
    }
  }

  @Override
  public ResponseEntity<RegistroDTO> atualizarRegistro(UUID registroId, AtualizaRegistroDTO body) {
    final var input = registroMapper.fromDTO(registroId.toString(), body);
    final var output = registroUpdateUseCase.execute(input);
    return ResponseEntity.ok(registroMapper.toDTO(output));
  }

  @Override
  public ResponseEntity<Void> deletaRegistro(UUID registroId) {
    registroDeleteUseCase.execute(registroId.toString());
    return ResponseEntity.noContent().build();
  }
}
