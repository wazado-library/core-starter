package com.wazado.corestarter.domain.entity.template.mapper;

public interface DaoMapper<Dao, Dto> {
    Dto toDto(Dao dao);
}
