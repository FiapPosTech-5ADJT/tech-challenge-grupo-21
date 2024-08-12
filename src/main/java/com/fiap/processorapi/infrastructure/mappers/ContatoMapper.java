package com.fiap.processorapi.infrastructure.mappers;

import com.fiap.processorapi.application.domain.contato.Contato;
import com.fiap.processorapi.application.domain.contato.ContatoId;
import com.fiap.processorapi.application.usecase.contato.create.ContatoCreateInput;
import com.fiap.processorapi.application.usecase.contato.create.ContatoCreateOutput;
import com.fiap.processorapi.application.usecase.contato.retrieve.get.ContatoGetByIdUseCaseOutput;
import com.fiap.processorapi.application.usecase.contato.retrieve.list.ContatoListOutput;
import com.fiap.processorapi.application.usecase.contato.update.ContatoUpdateUseCaseInput;
import com.fiap.processorapi.application.usecase.contato.update.ContatoUpdateUseCaseOutput;
import com.fiap.processorapi.contatos.model.AtualizaContatoDTO;
import com.fiap.processorapi.contatos.model.CriarContatoDTO;
import com.fiap.processorapi.contatos.model.ContatoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ContatoMapper {

  @Mapping(target = "id", expression = "java(java.util.UUID.fromString(contato.getId().toString()))")
  @Mapping(target = "createdAt", expression = "java(mapOffsetDateTime(contato.getCreatedAt()))")
  @Mapping(target = "deletedAt", expression = "java(mapOffsetDateTime(contato.getDeletedAt()))")
  @Mapping(target = "updatedAt", expression = "java(mapOffsetDateTime(contato.getUpdatedAt()))")
  ContatoDTO toDTO(Contato contato);

  @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().toString()))")
  @Mapping(target = "createdAt", expression = "java(mapOffsetDateTime(output.createdAt()))")
  @Mapping(target = "deletedAt", expression = "java(mapOffsetDateTime(output.deletedAt()))")
  @Mapping(target = "updatedAt", expression = "java(mapOffsetDateTime(output.updatedAt()))")
  ContatoDTO toDTO(ContatoCreateOutput output);

  @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().toString()))")
  ContatoDTO toDTO(ContatoListOutput output);

  List<ContatoDTO> toDTO(List<ContatoListOutput> output);

  @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().toString()))")
  ContatoDTO toDTO(ContatoGetByIdUseCaseOutput output);

  ContatoCreateInput fromDTO(CriarContatoDTO dto);

  @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().toString()))")
  @Mapping(target = "createdAt", expression = "java(mapOffsetDateTime(output.createdAt()))")
  @Mapping(target = "deletedAt", expression = "java(mapOffsetDateTime(output.deletedAt()))")
  @Mapping(target = "updatedAt", expression = "java(mapOffsetDateTime(output.updatedAt()))")
  ContatoDTO toDTO(ContatoUpdateUseCaseOutput output);

  @Mapping(target = "id", source = "contatoId")
  ContatoUpdateUseCaseInput fromDTO(String contatoId, AtualizaContatoDTO dto);

  default Instant mapInstant(OffsetDateTime offsetDateTime) {
    if (offsetDateTime == null) {
      return null;
    }
    return offsetDateTime.toInstant();
  }

  default OffsetDateTime mapOffsetDateTime(Instant instant) {
    if (instant == null) {
      return null;
    }
    return OffsetDateTime.ofInstant(instant, java.time.ZoneOffset.UTC);
  }

  default String map(ContatoId value) {
    return value.toString();
  }
}
