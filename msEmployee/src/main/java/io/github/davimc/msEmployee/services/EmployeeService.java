package io.github.davimc.msEmployee.services;

import io.github.davimc.msEmployee.dto.EmployeeDTO;
import io.github.davimc.msEmployee.entities.model.HiringRequest;
import io.github.davimc.msEmployee.dto.EmployeeUpdateDTO;
import io.github.davimc.msEmployee.entities.Employee;
import io.github.davimc.msEmployee.repository.EmployeeRepository;
import io.github.davimc.msExceptionHandler.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Transactional(readOnly = true)
    protected Employee findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id.toString(), Employee.class));
    }

    @Transactional(readOnly = true)
    public EmployeeDTO findByIdDTO(UUID id) {
        return new EmployeeDTO(findById(id));
    }

    @Transactional(readOnly = true)
    public EmployeeDTO findByCpf(String cpf) {
        Employee obj = repository.findByCpf(cpf).orElseThrow(() -> new ObjectNotFoundException(cpf, Employee.class));
        return new EmployeeDTO(obj);
    }

    @Transactional(readOnly = true)
    public Page<EmployeeDTO> findAll(Pageable pageable) {
        Page<Employee> obj = repository.findAll(pageable);

        return obj.map(EmployeeDTO::new);
    }

    @Transactional
    public Employee insert(HiringRequest dto) {
        Employee obj = dto.fromDTO();
        obj = repository.save(obj);

        return (obj);
    }

    @Transactional
    public EmployeeDTO update(UUID id, EmployeeUpdateDTO updateDTO) {
        Employee obj = findById(id);
        obj = updateDTO.fromDTO(obj);
        obj = repository.save(obj);

        return new EmployeeDTO(obj);
    }
}
