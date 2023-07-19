package io.github.davimc.msemplocontrol.services;

import io.github.davimc.msemplocontrol.infra.client.EmployeeResource;
import io.github.davimc.msemplocontrol.infra.client.StoreResource;
import io.github.davimc.msemplocontrol.infra.mqueue.EmployeePublisher;
import io.github.davimc.msemplocontrol.model.HiringRequest;
import io.github.davimc.msemplocontrol.model.DataStore;
import io.github.davimc.msemplocontrol.model.HiringProtocol;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmploControlService {
    private final EmployeeResource employeeResource;
    private final StoreResource storeResource;
    private final EmployeePublisher publisher;

    public HiringProtocol hiring(HiringRequest request) {
        ResponseEntity<DataStore> store = storeResource.findByCnpj(request.getStoreCnpj());
        request.setStoreId(store.getBody().getId());
        publisher.hiringEmployee(request);
        var protocol = UUID.randomUUID().toString();

        return new HiringProtocol(protocol);
    }
}
