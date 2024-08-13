package com.fiap.processorapi.application.usecase.contato;

import com.fiap.processorapi.application.domain.contato.Contato;
import com.fiap.processorapi.application.repositories.ContatoRepository;
import com.fiap.processorapi.application.usecase.contato.create.ContatoCreateInput;
import com.fiap.processorapi.application.usecase.contato.create.ContatoCreateOutput;
import com.fiap.processorapi.application.usecase.contato.create.ContatoCreateUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultContatoUseCase extends ContatoCreateUseCase {

    private final ContatoRepository contatoRepository;

    @Override
    public ContatoCreateOutput execute(ContatoCreateInput input) {
        final var newContato = Contato.newContato(input.nome(), input.email(), input.telefone());
        final var createContato = contatoRepository.create(newContato);
        return ContatoCreateOutput.from(createContato);
    }
}
