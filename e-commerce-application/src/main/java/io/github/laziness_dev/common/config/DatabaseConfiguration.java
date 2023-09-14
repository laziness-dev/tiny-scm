package io.github.laziness_dev.common.config;

import org.jooq.impl.DefaultConfiguration;
import org.springframework.boot.autoconfigure.jooq.DefaultConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jooq.jooq_dsl.tables.daos.ItemsDao;

@Configuration
public class DatabaseConfiguration implements DefaultConfigurationCustomizer {
    @Override
    public void customize(DefaultConfiguration configuration) {
        configuration.setAppending(AuditRecordListener::new);
    }

    @Bean
    public ItemsDao itemsDao(DefaultConfiguration configuration) {
        return new ItemsDao(configuration);
    }
}
