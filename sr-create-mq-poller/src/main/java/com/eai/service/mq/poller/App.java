package com.eai.service.mq.poller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import brave.sampler.Sampler;


@SpringBootApplication
@ImportResource({"classpath*:integration-context.xml"})
@EnableFeignClients("com.eai.service.mq.poller")
@EnableDiscoveryClient
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	

	// for distributive tracing
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
