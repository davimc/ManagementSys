package io.github.davimc.msexchange.repositories;

import io.github.davimc.msexchange.domain.DataEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployeeExchangeRepository extends JpaRepository<DataEmployee, UUID> {
    Optional<DataEmployee> findByCpf(String cpf);
}
