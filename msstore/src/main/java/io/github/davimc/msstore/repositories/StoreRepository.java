package io.github.davimc.msstore.repositories;

import io.github.davimc.msstore.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
    Optional<Store> findByCnpj(String cnpj);
}
