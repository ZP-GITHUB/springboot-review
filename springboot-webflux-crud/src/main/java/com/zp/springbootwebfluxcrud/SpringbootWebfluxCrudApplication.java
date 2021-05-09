package com.zp.springbootwebfluxcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class SpringbootWebfluxCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebfluxCrudApplication.class, args);
	}

}
