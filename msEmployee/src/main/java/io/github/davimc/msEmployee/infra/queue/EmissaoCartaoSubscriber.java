package io.github.davimc.msEmployee.infra.queue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.davimc.msEmployee.entities.model.HiringRequest;
import io.github.davimc.msEmployee.entities.Employee;
import io.github.davimc.msEmployee.entities.StoreEmployee;
import io.github.davimc.msEmployee.services.EmployeeService;
import io.github.davimc.msEmployee.services.StoreEmployeeService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmissaoCartaoSubscriber {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private StoreEmployeeService storeEmployeeService;
    // TODO Tratamento para mensagens enviadas incorretamente
    @RabbitListener(queues = "${mq.queues.employee-queue}")
    public void receiveHiringRequest(@Payload String payload){
        try{
            HiringRequest model = new ObjectMapper().readValue(payload, HiringRequest.class);
            Employee obj = employeeService.insert(model);
            StoreEmployee store = storeEmployeeService.hiringEmployee(model, obj);

        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }


}
