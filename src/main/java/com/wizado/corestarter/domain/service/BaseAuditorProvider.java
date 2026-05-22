package com.wizado.corestarter.domain.service;

import java.util.Optional;

public interface BaseAuditorProvider {
    Optional<String> getAuditor();
}
