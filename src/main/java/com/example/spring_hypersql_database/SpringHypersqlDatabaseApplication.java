package com.example.spring_hypersql_database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringHypersqlDatabaseApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringHypersqlDatabaseApplication.class, args);
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... args) throws Exception {
		jdbcTemplate.execute("INSERT INTO PERSON(person_id, first_name, last_name) VALUES (1, 'marcus', 'chiu')");
		int result = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM PERSON", Integer.class);
		System.out.println("1. " + result);
	}
}
