package com.zp.springbootbatchitemwriter;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class SpringbootBatchItemwriterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBatchItemwriterApplication.class, args);
	}

}
