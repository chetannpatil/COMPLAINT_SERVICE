package io.chetan;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableEurekaClient
public class ComplaintServiceApplication {

	private static Logger LOGGER = LogManager.getLogger(ComplaintServiceApplication.class);
	
	@Bean
	public Sampler defaultSampler() 
	{
		LOGGER.info("\n\n ComplaintServiceApplication - defaultSampler- \n\n");
		return Sampler.ALWAYS_SAMPLE;
	}
	
	public static void main(String[] args) {
		
		LOGGER.info("\n\n ComplaintServiceApplication - main- \n\n");
		SpringApplication.run(ComplaintServiceApplication.class, args);
	}

}
