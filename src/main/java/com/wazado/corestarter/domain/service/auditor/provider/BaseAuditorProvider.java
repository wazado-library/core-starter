package com.wazado.corestarter.domain.service.auditor.provider;

import java.util.Optional;

public interface BaseAuditorProvider {
    Optional<String> getAuditor();
}
