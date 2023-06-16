package io.github.davimc.msEmployee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsEmployeeApplication.class, args);
	}

}
