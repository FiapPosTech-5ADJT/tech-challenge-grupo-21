package com.fiap.processorapi.infrastructure.persistence.respositories;

import com.fiap.processorapi.application.enums.Status;
import com.fiap.processorapi.infrastructure.persistence.entities.RegistroJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistroJPARepository extends JpaRepository<RegistroJPAEntity, String> {

  List<RegistroJPAEntity> findByStatus(int status);
}
