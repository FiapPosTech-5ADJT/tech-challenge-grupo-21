package com.fiap.processorapi.application.usecase.contato.delete;

import com.fiap.processorapi.application.domain.contato.ContatoId;
import com.fiap.processorapi.application.repositories.ContatoRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultContatoDeleteUseCase extends ContatoDeleteUseCase {
    private final ContatoRepository contatoRepository;

    @Override
    public void execute(final String input) {
        final var contatoId = ContatoId.from(input);
        contatoRepository.deleteById(contatoId);
    }

}
