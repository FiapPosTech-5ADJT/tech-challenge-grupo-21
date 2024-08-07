package com.fiap.processorapi.infrastructure.respositories;

import com.fiap.processorapi.application.domain.registro.Registro;
import com.fiap.processorapi.application.domain.registro.RegistroId;
import com.fiap.processorapi.application.repositories.RegistroRepository;
import com.fiap.processorapi.infrastructure.persistence.entities.RegistroJPAEntity;
import com.fiap.processorapi.infrastructure.persistence.respositories.RegistroJPARepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class RegistroRepositoryImpl implements RegistroRepository {

  private final RegistroJPARepository  registroJPARepository;

  @Override
  public Registro create(Registro registro) {
    return this.save(registro);
  }

  @Override
  public Registro update(Registro aRegistro) {
    return null;
  }

  @Override
  public Optional<Registro> findById(RegistroId anId) {
    return Optional.empty();
  }

  @Override
  public List<Registro> findAll() {
    return registroJPARepository.findAll().stream().map(RegistroJPAEntity::toRegistro).toList() ;
  }

  @Override
  public void deleteById(RegistroId anId) {

  }

  private Registro save(Registro registro) {
    return registroJPARepository.save(RegistroJPAEntity.of(registro)).toRegistro();
  }

}
