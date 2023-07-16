package io.github.davimc.msemplocontrol.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQConfig {
    @Value("${mq.queues.employee-queue}")
    private String employeeQueue;

    @Bean
    public Queue queueHiring() {
        return new Queue(employeeQueue,true);
    }
}
