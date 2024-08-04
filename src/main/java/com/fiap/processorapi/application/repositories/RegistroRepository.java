package com.fiap.processorapi.application.repositories;

import com.fiap.processorapi.application.domain.registro.Registro;
import com.fiap.processorapi.application.domain.registro.RegistroId;

import java.util.List;
import java.util.Optional;

public interface RegistroRepository {

      Registro create(Registro rgistro);

      Registro update(Registro aRegistro);

      Optional<Registro> findById(RegistroId anId);

      List<Registro> findAll();

      void deleteById(RegistroId anId);
}
