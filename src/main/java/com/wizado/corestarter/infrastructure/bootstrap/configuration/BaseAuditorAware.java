package com.wizado.corestarter.infrastructure.bootstrap.configuration;

import com.wizado.corestarter.domain.service.auditor.provider.BaseAuditorProvider;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BaseAuditorAware implements AuditorAware<String> {
    BaseAuditorProvider baseAuditorProvider;

    @Override
    @NonNull
    public Optional<String> getCurrentAuditor() {
        return baseAuditorProvider.getAuditor();
    }
}
