package io.github.davimc.msEmployee.repository;

import io.github.davimc.msEmployee.entities.StoreEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreEmployeeRepository extends JpaRepository<StoreEmployee, Long> {
    List<StoreEmployee> findByCnpj(String cnpj);
}
