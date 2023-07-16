package io.github.davimc.msemplocontrol.infra.mqueue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.davimc.msemplocontrol.model.HiringRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeePublisher {
    private final RabbitTemplate rabbitTemplate;
    private final Queue queueEmployeePublisher;

    public void hiringEmployee(HiringRequest data) {
        try {
            var json = convertIntoJson(data);
            rabbitTemplate.convertAndSend(queueEmployeePublisher.getName(), json);
        }// todo Exception handler
        catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
    private String convertIntoJson(HiringRequest data) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        var json = mapper.writeValueAsString(data);

        return json;
    }
}
