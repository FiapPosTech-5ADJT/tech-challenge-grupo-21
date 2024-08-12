package com.fiap.processorapi.infrastructure.respositories;

import com.fiap.processorapi.application.repositories.CredenciamentoRepository;
import com.fiap.processorapi.infrastructure.persistence.entities.CredenciamentoJPAEntity;
import com.fiap.processorapi.infrastructure.persistence.respositories.CredenciamentoJPARepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class CredenciamentoRepositoryImpl implements CredenciamentoRepository {

  private final CredenciamentoJPARepository credenciamentoJPARepository;

  @Override
  public Optional<CredenciamentoJPAEntity> findByNumeroDocumento(String numeroDocumento) {
    return credenciamentoJPARepository.findByNumeroDocumento(numeroDocumento);
  }

  @Transactional
  @Override
  public CredenciamentoJPAEntity save(CredenciamentoJPAEntity cred) {
    return credenciamentoJPARepository.save(cred);
  }
}
