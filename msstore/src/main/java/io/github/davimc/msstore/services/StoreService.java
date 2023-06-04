package io.github.davimc.msstore.services;

import io.github.davimc.msstore.dto.StoreDTO;
import io.github.davimc.msstore.entities.Store;
import io.github.davimc.msstore.repositories.StoreRepository;
import io.github.davimc.msstore.services.ex.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StoreService {

    @Autowired
    private StoreRepository repository;

    @Transactional(readOnly = true)
    public StoreDTO find(Long id) {
        Store obj = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, Store.class));
        return new StoreDTO(obj);
    }

    @Transactional
    public StoreDTO insert(StoreDTO dto) {
        Store obj = new Store();
        obj.setName(dto.getName());
        obj = repository.save(obj);

        return new StoreDTO(obj);
    }
}
