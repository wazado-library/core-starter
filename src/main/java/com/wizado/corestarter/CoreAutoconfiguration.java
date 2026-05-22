package com.wizado.corestarter;

import com.wizado.corestarter.adapter.GlobalControllerAdapter;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class CoreAutoconfiguration {
    @Bean
    @ConditionalOnMissingBean
    public GlobalControllerAdapter globalControllerAdapter() {
        return new GlobalControllerAdapter();
    }
}
