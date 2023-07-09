package io.github.davimc.msEmployee;

import io.github.davimc.msEmployee.config.YAMLConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsEmployeeApplication implements CommandLineRunner {

	@Autowired
	private YAMLConfig myConfig;

	public static void main(String[] args) {
		SpringApplication.run(MsEmployeeApplication.class, args);
	}

	public void run(String... args) {
		System.out.println("using environment: " + myConfig.getEnvironment());
		System.out.println("name: " + myConfig.getName());
		System.out.println("enabled:" + myConfig.isEnabled());
		System.out.println("servers: " + myConfig.getServers());
	}

}
