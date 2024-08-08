package com.fiap.processorapi.infrastructure.mappers;

import com.fiap.processorapi.application.domain.registro.Registro;
import com.fiap.processorapi.application.domain.registro.RegistroId;
import com.fiap.processorapi.application.usecase.registro.create.RegistroCreateInput;
import com.fiap.processorapi.application.usecase.registro.create.RegistroCreateOutput;
import com.fiap.processorapi.application.usecase.registro.retrieve.get.RegistroGetByIdUseCaseOutput;
import com.fiap.processorapi.application.usecase.registro.retrieve.list.RegistroListOutput;
import com.fiap.processorapi.application.usecase.registro.update.RegistroUpdateUseCaseInput;
import com.fiap.processorapi.application.usecase.registro.update.RegistroUpdateUseCaseOutput;
import com.fiap.processorapi.registros.model.AtualizaRegistroDTO;
import com.fiap.processorapi.registros.model.CriarRegistroDTO;
import com.fiap.processorapi.registros.model.RegistroDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;

@Mapper(componentModel = "spring")
public interface RegistroMapper {

  @Mapping(target = "id", expression = "java(java.util.UUID.fromString(registro.getId().toString()))")
  @Mapping(target = "dataProcessamento", expression = "java(mapOffsetDateTime(registro.getDataProcessamento()))")
  @Mapping(target = "createdAt", expression = "java(mapOffsetDateTime(registro.getCreatedAt()))")
  @Mapping(target = "deletedAt", expression = "java(mapOffsetDateTime(registro.getDeletedAt()))")
  @Mapping(target = "updatedAt", expression = "java(mapOffsetDateTime(registro.getUpdatedAt()))")
  RegistroDTO toDTO(Registro registro);

  @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().toString()))")
  @Mapping(target = "dataProcessamento", expression = "java(mapOffsetDateTime(output.dataProcessamento()))")
  @Mapping(target = "createdAt", expression = "java(mapOffsetDateTime(output.createdAt()))")
  @Mapping(target = "deletedAt", expression = "java(mapOffsetDateTime(output.deletedAt()))")
  @Mapping(target = "updatedAt", expression = "java(mapOffsetDateTime(output.updatedAt()))")
  RegistroDTO toDTO(RegistroCreateOutput output);

  @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().toString()))")
  RegistroDTO toDTO(RegistroListOutput output);

  List<RegistroDTO> toDTO(List<RegistroListOutput> output);

  @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().toString()))")
  RegistroDTO toDTO(RegistroGetByIdUseCaseOutput output);

  RegistroCreateInput fromDTO(CriarRegistroDTO dto);

  @Mapping(target = "id", expression = "java(java.util.UUID.fromString(output.id().toString()))")
  @Mapping(target = "dataProcessamento", expression = "java(mapOffsetDateTime(output.dataProcessamento()))")
  @Mapping(target = "createdAt", expression = "java(mapOffsetDateTime(output.createdAt()))")
  @Mapping(target = "deletedAt", expression = "java(mapOffsetDateTime(output.deletedAt()))")
  @Mapping(target = "updatedAt", expression = "java(mapOffsetDateTime(output.updatedAt()))")
  @Mapping(target = "status", source = "output.status")
  @Mapping(target = "numTentativas", source = "output.numTentativas")
  RegistroDTO toDTO(RegistroUpdateUseCaseOutput output);

  @Mapping(target = "id", source = "registroId")
  @Mapping(target = "dataProcessamento", expression = "java(mapInstant(dto.getDataProcessamento()))")
  @Mapping(target = "status", source = "dto.status")
  @Mapping(target = "numTentativas", source = "dto.numTentativas")
  RegistroUpdateUseCaseInput fromDTO(String registroId, AtualizaRegistroDTO dto);

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
  default String map(RegistroId value) {
    return value.toString();
  }
}
