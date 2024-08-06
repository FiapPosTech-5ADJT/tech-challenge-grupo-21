package com.fiap.processorapi.application.repositories;

import com.fiap.processorapi.application.domain.contato.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContatoRepository extends JpaRepository<Contato, UUID> {
}
