package com.github.abigail830.authmaven;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.github.abigail830.authmaven.infrastructure.mapper")
public class AuthMavenApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthMavenApplication.class, args);
	}

}
