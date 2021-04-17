package com.zp.springbootbatchstart;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class SpringbootBatchStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBatchStartApplication.class, args);
	}

}
