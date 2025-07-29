package com.example.spring_hypersql_database;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DefaultConfig {

    /**
     *
     * @param dataSource was autoconfigured by
     *                   `org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration`
     * @return
     */
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
