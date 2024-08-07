package com.fiap.processorapi.infrastructure.mappers;

import com.fiap.processorapi.application.domain.registro.Registro;
import com.fiap.processorapi.application.usecase.registro.create.RegistroCreateInput;
import com.fiap.processorapi.application.usecase.registro.create.RegistroCreateOutput;
import com.fiap.processorapi.application.usecase.registro.retrieve.list.RegistroListOutput;
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

  RegistroCreateInput fromDTO(CriarRegistroDTO dto);

  default OffsetDateTime mapOffsetDateTime(Instant instant) {
    if (instant == null) {
      return null;
    }
    return OffsetDateTime.ofInstant(instant, java.time.ZoneOffset.UTC);
  }

}
