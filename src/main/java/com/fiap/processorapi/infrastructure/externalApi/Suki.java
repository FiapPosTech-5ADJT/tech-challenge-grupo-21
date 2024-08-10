package com.fiap.processorapi.infrastructure.externalApi;

import com.fiap.processorapi.application.domain.registro.Registro;
import lombok.RequiredArgsConstructor;

import java.util.Random;

@RequiredArgsConstructor
public class Suki {
    public String sendSukiData(final Registro registro) {
        // Simula um comportamento aleatório para a resposta da API
        final String payload = registro.getPayloadCredenciamento();
        final Random random = new Random();
        final int chance = random.nextInt(100);

        if (chance < 80) {  // 80% de chance de sucesso
            return "Success";
        } else {
            return "Failure";
        }
    }
}
