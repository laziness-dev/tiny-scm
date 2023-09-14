package io.github.laziness_dev.common.config;

import jooq.jooq_dsl.tables.daos.ItemsDao;
import org.jooq.RecordListenerProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfiguration {
    @Bean
    public RecordListenerProvider recordListenerProvider() {
        return AuditRecordListener::new;
    }

    @Bean
    public ItemsDao userDao(org.jooq.Configuration configuration) {
        return new ItemsDao(configuration);
    }
}
