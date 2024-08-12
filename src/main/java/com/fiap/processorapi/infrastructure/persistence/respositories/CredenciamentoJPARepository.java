package com.fiap.processorapi.infrastructure.persistence.respositories;

import com.fiap.processorapi.infrastructure.persistence.entities.CredenciamentoJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CredenciamentoJPARepository extends JpaRepository<CredenciamentoJPAEntity, UUID> {

  Optional<CredenciamentoJPAEntity> findByNumeroDocumento(String numeroDocumento);
}
