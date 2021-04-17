package com.zp.springbootbatchitemreader;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class SpringbootBatchItemreaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBatchItemreaderApplication.class, args);
	}

}
