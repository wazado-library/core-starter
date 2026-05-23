package com.wazado.corestarter;

import com.wazado.corestarter.adapter.GlobalControllerAdapter;
import com.wazado.corestarter.domain.service.auditor.provider.BaseAuditorProvider;
import com.wazado.corestarter.infrastructure.bootstrap.configuration.BaseAuditorAware;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@AutoConfiguration
public class CoreAutoconfiguration {
    @Bean
    @ConditionalOnMissingBean
    public GlobalControllerAdapter globalControllerAdapter() {
        return new GlobalControllerAdapter();
    }

    @Bean
    @ConditionalOnMissingBean
    public BaseAuditorProvider baseAuditorProvider() {
        return () -> Optional.of("System");
    }

    @Bean
    @ConditionalOnMissingBean
    public BaseAuditorAware baseAuditorAware(BaseAuditorProvider baseAuditorProvider) {
        return new BaseAuditorAware(baseAuditorProvider);
    }
}
