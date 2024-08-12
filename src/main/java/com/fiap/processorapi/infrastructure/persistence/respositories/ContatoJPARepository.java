package com.fiap.processorapi.infrastructure.persistence.respositories;


import com.fiap.processorapi.infrastructure.persistence.entities.ContatoJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ContatoJPARepository extends JpaRepository<ContatoJPAEntity, UUID> {

  List<ContatoJPAEntity> findAll();
}
