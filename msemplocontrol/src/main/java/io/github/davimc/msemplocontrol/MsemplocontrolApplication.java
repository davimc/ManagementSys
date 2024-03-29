package io.github.davimc.msemplocontrol;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableRabbit
public class MsemplocontrolApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsemplocontrolApplication.class, args);
	}

}
