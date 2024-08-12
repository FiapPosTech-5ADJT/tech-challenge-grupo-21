package com.fiap.processorapi.application.repositories;

import com.fiap.processorapi.infrastructure.persistence.entities.CredenciamentoJPAEntity;

import java.util.Optional;

public interface CredenciamentoRepository {

  Optional<CredenciamentoJPAEntity> findByNumeroDocumento(String numeroDocumento);


  CredenciamentoJPAEntity save(CredenciamentoJPAEntity cred);
}
