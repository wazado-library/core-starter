package com.wazado.corestarter.domain.entity.template.mapper;

import org.mapstruct.MappingTarget;

import java.util.List;

public interface EntityMapper<Entity, Dto> {
    Entity toEntity(Dto dto);
    Dto toDto(Entity entity);
    List<Entity> toEntity(List<Dto> dto);
    List<Dto> toDto(List<Entity> entities);
    void update(@MappingTarget Entity entity, Dto dto);
}
