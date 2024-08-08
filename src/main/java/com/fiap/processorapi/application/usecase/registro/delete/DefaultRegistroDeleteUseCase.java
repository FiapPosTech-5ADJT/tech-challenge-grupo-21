package com.fiap.processorapi.application.usecase.registro.delete;

import com.fiap.processorapi.application.domain.registro.RegistroId;
import com.fiap.processorapi.application.repositories.RegistroRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultRegistroDeleteUseCase extends RegistroDeleteUseCase {
    private final RegistroRepository registroRepository;

    @Override
    public void execute(final String input) {
        final var registroId = RegistroId.from(input);
      registroRepository.deleteById(registroId);
    }

}
