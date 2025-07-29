-- If datasource points to a non-embedded database, then Spring Boot doesn't run this.
-- To re-enabled this, set property spring.sql.init.mode=always
--
-- The actual class that read schema.sql and execute it used to be DataSourceInitializer#createSchema().
-- As of Spring Boot 3.3, it is in SettingsCreator.
--
-- Here are the high level flow which somehow triggers it:
-- * If DataSource class is found from the class-path, spring-boot auto-configuration will enable DataSourceAutoConfiguration
-- * DataSourceAutoConfiguration imports DataSourceInitializationConfiguration
-- * DataSourceInitializationConfiguration registers DataSourceInitializerPostProcessor which will be executed and force initialising DataSourceInitializerInvoker.
-- * DataSourceInitializerInvoker's afterPropertiesSet will then execute DataSourceInitializer#createSchema() to read and execute schema.sql

DROP TABLE PERSON IF EXISTS;

CREATE TABLE PERSON  (
    person_id BIGINT IDENTITY NOT NULL PRIMARY KEY,
    first_name VARCHAR(20),
    last_name VARCHAR(20)
);
