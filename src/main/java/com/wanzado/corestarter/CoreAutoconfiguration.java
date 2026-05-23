package com.wanzado.corestarter;

import com.wanzado.corestarter.adapter.GlobalControllerAdapter;
import com.wanzado.corestarter.domain.service.auditor.provider.BaseAuditorProvider;
import com.wanzado.corestarter.infrastructure.bootstrap.configuration.BaseAuditorAware;
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
