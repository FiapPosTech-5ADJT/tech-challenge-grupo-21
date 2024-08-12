package com.fiap.processorapi.infrastructure.config;

import com.fiap.processorapi.application.repositories.ContatoRepository;
import com.fiap.processorapi.application.repositories.CredenciamentoRepository;
import com.fiap.processorapi.application.repositories.RegistroRepository;
import com.fiap.processorapi.application.usecase.DefaultRegistroUseCase;
import com.fiap.processorapi.application.usecase.contato.retrieve.list.ContatoListUseCase;
import com.fiap.processorapi.application.usecase.contato.retrieve.list.DefaultListContatoUseCase;
import com.fiap.processorapi.application.usecase.registro.create.RegistroCreateUseCase;
import com.fiap.processorapi.application.usecase.registro.delete.DefaultRegistroDeleteUseCase;
import com.fiap.processorapi.application.usecase.registro.delete.RegistroDeleteUseCase;
import com.fiap.processorapi.application.usecase.registro.retrieve.get.DefaultRegistroGetByIdUseCase;
import com.fiap.processorapi.application.usecase.registro.retrieve.get.RegistroGetByIdUseCase;
import com.fiap.processorapi.application.usecase.registro.retrieve.list.DefaultListRegistroUseCase;
import com.fiap.processorapi.application.usecase.registro.retrieve.list.RegistroListUseCase;
import com.fiap.processorapi.application.usecase.registro.update.DefaultRegistroUpdateUseCase;
import com.fiap.processorapi.application.usecase.registro.update.RegistroUpdateUseCase;
import com.fiap.processorapi.infrastructure.persistence.respositories.ContatoJPARepository;
import com.fiap.processorapi.infrastructure.persistence.respositories.CredenciamentoJPARepository;
import com.fiap.processorapi.infrastructure.persistence.respositories.RegistroJPARepository;
import com.fiap.processorapi.infrastructure.respositories.ContatoRepositoryImpl;
import com.fiap.processorapi.infrastructure.respositories.CredenciamentoRepositoryImpl;
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

  @Bean
  public RegistroGetByIdUseCase registroGetByIdUseCase(final RegistroRepository registroRepository) {
    return new DefaultRegistroGetByIdUseCase(registroRepository);
  }

  @Bean
  public RegistroUpdateUseCase registroUpdateUseCase(final RegistroRepository registroRepository) {
    return new DefaultRegistroUpdateUseCase(registroRepository);
  }

  @Bean
  public RegistroDeleteUseCase registroDeleteUseCase(final RegistroRepository registroRepository) {
    return new DefaultRegistroDeleteUseCase(registroRepository);
  }

  @Bean
  public ContatoRepository contatoRepository(final ContatoJPARepository contatoJPARepository) {
    return new ContatoRepositoryImpl(contatoJPARepository);
  }

  @Bean
  public CredenciamentoRepository credenciamentoRepository(final CredenciamentoJPARepository credenciamentoJPARepository) {
    return new CredenciamentoRepositoryImpl(credenciamentoJPARepository);
  }

  @Bean
  public ContatoListUseCase contatoListUseCase(final ContatoRepository contatoRepository) {
    return new DefaultListContatoUseCase(contatoRepository);
  }

}
