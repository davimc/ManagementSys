package io.github.davimc.msexchange.services;

import io.github.davimc.msExceptionHandler.exceptions.ObjectNotFoundException;
import io.github.davimc.msexchange.domain.Exchange;
import io.github.davimc.msexchange.dto.ExchangeDTO;
import io.github.davimc.msexchange.repositories.ExchangeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ExchangeService {
    private final ExchangeRepository repository;

    protected Exchange findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, Exchange.class));
    }
    public ExchangeDTO findByIdDTO (UUID id) {
        Exchange obj = findById(id);

        return new ExchangeDTO(obj);
    }
}
