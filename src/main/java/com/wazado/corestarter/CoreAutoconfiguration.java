package com.wazado.corestarter;

import com.wazado.corestarter.adapter.GlobalControllerAdapter;
import com.wazado.corestarter.domain.service.auditor.provider.BaseAuditorProvider;
import com.wazado.corestarter.infrastructure.bootstrap.configuration.auditor.BaseAuditorAware;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.auditing.DateTimeProvider;

import java.time.LocalDateTime;
import java.time.ZoneId;
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

    @Bean
    @ConditionalOnMissingBean
    public DateTimeProvider dateTimeProvider() {
        return () -> Optional.of(LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh")));
    }

}
