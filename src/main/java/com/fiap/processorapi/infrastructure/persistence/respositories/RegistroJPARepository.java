package com.fiap.processorapi.infrastructure.persistence.respositories;

import com.fiap.processorapi.infrastructure.persistence.entities.RegistroJPAEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroJPARepository extends JpaRepository<RegistroJPAEntity, String> {
}
