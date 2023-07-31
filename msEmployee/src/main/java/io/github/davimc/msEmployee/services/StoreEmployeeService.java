package io.github.davimc.msEmployee.services;

import io.github.davimc.msEmployee.entities.model.HiringRequest;
import io.github.davimc.msEmployee.dto.storeEmployee.StoreEmployeeDTO;
import io.github.davimc.msEmployee.entities.Employee;
import io.github.davimc.msEmployee.entities.StoreEmployee;
import io.github.davimc.msEmployee.repository.StoreEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StoreEmployeeService {

    @Autowired
    private StoreEmployeeRepository repository;

    @Transactional(readOnly = true)
    public List<StoreEmployeeDTO> findByCnpj(String cnpj) {
        return repository.findByCnpj(cnpj).stream().map(StoreEmployeeDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public StoreEmployee hiringEmployee(HiringRequest dto, Employee newEmploeee) {
        StoreEmployee obj = repository.findById(dto.getStoreId()).orElseGet(() -> {
            StoreEmployee s = new StoreEmployee();
            s.setId(dto.getStoreId());
            s.setCnpj(dto.getStoreCnpj());

            return s;
        });
        obj.getEmployee().add(newEmploeee);

        return repository.save(obj);
    }

}
