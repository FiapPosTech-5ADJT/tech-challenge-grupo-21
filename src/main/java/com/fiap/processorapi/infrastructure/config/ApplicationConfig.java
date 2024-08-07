package com.fiap.processorapi.infrastructure.config;

import com.fiap.processorapi.application.repositories.RegistroRepository;
import com.fiap.processorapi.application.usecase.DefaultRegistroUseCase;
import com.fiap.processorapi.application.usecase.registro.create.RegistroCreateUseCase;
import com.fiap.processorapi.application.usecase.registro.retrieve.list.DefaultListRegistroUseCase;
import com.fiap.processorapi.application.usecase.registro.retrieve.list.RegistroListUseCase;
import com.fiap.processorapi.infrastructure.persistence.respositories.RegistroJPARepository;
import com.fiap.processorapi.infrastructure.respositories.RegistroRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

  @Bean
  public RegistroRepository registroRepository(final RegistroJPARepository registroJPARepository) {
    return new RegistroRepositoryImpl(registroJPARepository);
  }

  @Bean
  public RegistroCreateUseCase registroCreateUseCase(final RegistroRepository registroRepository) {
    return new DefaultRegistroUseCase(registroRepository);
  }

  @Bean
  public RegistroListUseCase categoryListUseCase(final RegistroRepository registroRepository) {
    return new DefaultListRegistroUseCase(registroRepository);
  }


}
