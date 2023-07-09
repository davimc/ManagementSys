package io.github.davimc.msEmployee.services;

import io.github.davimc.msEmployee.dto.storeEmployee.StoreEmployeeDTO;
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

}
