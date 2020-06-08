package com.eai.naming.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import io.dekorate.kubernetes.annotation.KubernetesApplication;

@KubernetesApplication
@SpringBootApplication
@EnableEurekaServer
public class EaiNamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EaiNamingServerApplication.class, args);
	}

}
