      package com.fiap.processorapi.application.repositories;

import com.fiap.processorapi.application.domain.registro.Registro;
import com.fiap.processorapi.application.domain.registro.RegistroId;
import com.fiap.processorapi.application.enums.Status;

import java.util.List;
import java.util.Optional;

public interface RegistroRepository {

      Registro create(Registro rgistro);

      Registro update(Registro aRegistro);

      Optional<Registro> findById(RegistroId anId);

      List<Registro> findAll();

      List<Registro> findByStatus(Status status);

      void updateStatus(Registro aRegistro);

      void deleteById(RegistroId anId);
}
