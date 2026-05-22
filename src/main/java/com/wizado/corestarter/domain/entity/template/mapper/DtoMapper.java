package com.wizado.corestarter.domain.entity.template.mapper;

import org.mapstruct.MappingTarget;

import java.util.List;

public interface DtoMapper<Dto, Domain> {
    Dto toDto(Domain dto);
    Domain toDomain(Dto dto);
    List<Dto> toDto(List<Domain> domain);
    List<Domain> toDomain(List<Dto> dto);
}
