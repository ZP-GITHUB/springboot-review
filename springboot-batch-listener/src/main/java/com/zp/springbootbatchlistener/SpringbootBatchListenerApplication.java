package com.zp.springbootbatchlistener;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class SpringbootBatchListenerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBatchListenerApplication.class, args);
	}

}
