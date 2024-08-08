package com.fiap.processorapi.infrastructure.respositories;

import com.fiap.processorapi.application.domain.registro.Registro;
import com.fiap.processorapi.application.domain.registro.RegistroId;
import com.fiap.processorapi.application.enums.Status;
import com.fiap.processorapi.application.repositories.RegistroRepository;
import com.fiap.processorapi.infrastructure.persistence.entities.RegistroJPAEntity;
import com.fiap.processorapi.infrastructure.persistence.respositories.RegistroJPARepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class RegistroRepositoryImpl implements RegistroRepository {

  private final RegistroJPARepository  registroJPARepository;

  @Override
  @Transactional
  public Registro create(Registro registro) {
    return this.save(registro);
  }

  @Transactional
  @Override
  public Registro update(Registro aRegistro) {
    return this.save(aRegistro);
  }

  @Override
  public Optional<Registro> findById(RegistroId anId) {
    return registroJPARepository.findById(anId.value()).map(RegistroJPAEntity::toRegistro);
  }

  @Override
  public List<Registro> findAll() {
    return registroJPARepository.findAll().stream().map(RegistroJPAEntity::toRegistro).toList() ;
  }

  @Override
  public List<Registro> findByStatus(Status status) {
    return registroJPARepository.findByStatus(status.getValue()).stream()
      .map(RegistroJPAEntity::toRegistro)
      .toList();
  }

  @Transactional
  @Override
  public void updateStatus(Registro aRegistro) {
    this.save(aRegistro);
  }

  @Transactional
  @Override
  public void deleteById(RegistroId anId) {
    registroJPARepository.deleteById(anId.value());
  }

  private Registro save(Registro registro) {
    return registroJPARepository.save(RegistroJPAEntity.of(registro)).toRegistro();
  }

}
