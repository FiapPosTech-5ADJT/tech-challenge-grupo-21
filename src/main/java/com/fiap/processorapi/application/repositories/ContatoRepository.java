package com.fiap.processorapi.application.repositories;

import com.fiap.processorapi.application.domain.contato.Contato;
import com.fiap.processorapi.application.domain.contato.ContatoId;

import java.util.List;
import java.util.Optional;

public interface ContatoRepository {
    Contato create(Contato contato);
    Contato update(Contato contato);
    Optional<Contato> findById(ContatoId id);
    List<Contato> findAll();
    void deleteById(ContatoId anId);
}
