package com.eai.srcreate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import brave.sampler.Sampler;

@SpringBootApplication
@ImportResource({"classpath*:integration-context.xml"})
@EnableDiscoveryClient
public class SrCreateUpdateIncidentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SrCreateUpdateIncidentApplication.class, args);
	}
	

	// for distributive tracing
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
