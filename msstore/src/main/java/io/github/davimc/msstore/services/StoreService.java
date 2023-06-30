package io.github.davimc.msstore.services;

import io.github.davimc.msExceptionHandler.exceptions.ObjectNotFoundException;
import io.github.davimc.msstore.dto.StoreDTO;
import io.github.davimc.msstore.dto.StoreNewDTO;
import io.github.davimc.msstore.entities.Store;
import io.github.davimc.msstore.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StoreService {

    @Autowired
    private StoreRepository repository;


    @Transactional(readOnly = true)
    public List<StoreDTO> findAll() {
        return repository.findAll().stream().map(StoreDTO::new).toList();
    }
    @Transactional(readOnly = true)
    public StoreDTO find(Long id) {
        Store obj = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, Store.class));
        return new StoreDTO(obj);
    }

    @Transactional
    public StoreDTO insert(StoreNewDTO dto) {
        Store obj = new Store();
        obj = dto.fromDTO();
        obj = repository.save(obj);

        return new StoreDTO(obj);
    }
}
