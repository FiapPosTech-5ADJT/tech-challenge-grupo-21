package com.fiap.processorapi.infrastructure.respositories;

import com.fiap.processorapi.application.domain.contato.Contato;
import com.fiap.processorapi.application.domain.contato.ContatoId;
import com.fiap.processorapi.application.repositories.ContatoRepository;
import com.fiap.processorapi.infrastructure.persistence.entities.ContatoJPAEntity;
import com.fiap.processorapi.infrastructure.persistence.respositories.ContatoJPARepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
public class ContatoRepositoryImpl implements ContatoRepository {

  private final ContatoJPARepository contatoJPARepository;

  @Override
  @Transactional
  public Contato create(Contato contato) {
    return this.save(contato);
  }

  private Contato save(Contato contato) {
    return contatoJPARepository.save(ContatoJPAEntity.of(contato)).toContato();
  }

  @Override
  public Contato update(Contato contato) {
    return null;
  }

  @Override
  public Optional<Contato> findById(ContatoId id) {
    return Optional.empty();
  }

  @Override
  public List<Contato> findAll() {
    return contatoJPARepository.findAll().stream().map(ContatoJPAEntity::toContato).toList();
  }

  @Override
  public void deleteById(ContatoId id) {

  }
}
