package com.wizado.corestarter.domain.entity.template.mapper;

import java.util.List;

public interface DaoMapper<Dao, Dto> {
    Dto toDto(Dao dao);
}
