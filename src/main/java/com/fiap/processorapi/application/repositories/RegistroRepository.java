package com.fiap.processorapi.application.repositories;

import com.fiap.processorapi.application.domain.registro.Registro;
import com.fiap.processorapi.application.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RegistroRepository extends JpaRepository<Registro, UUID> {
      List<Registro> findByStatus(Status status);
}
