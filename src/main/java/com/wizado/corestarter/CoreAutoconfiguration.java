package com.wizado.corestarter;

import com.wizado.corestarter.adapter.GlobalControllerAdapter;
import com.wizado.corestarter.domain.service.auditor.provider.BaseAuditorProvider;
import com.wizado.corestarter.infrastructure.bootstrap.BaseAuditorAware;
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
