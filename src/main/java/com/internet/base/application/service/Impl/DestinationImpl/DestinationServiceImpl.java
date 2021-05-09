package com.internet.base.application.service.Impl.DestinationImpl;

import com.internet.base.application.model.Destination;
import com.internet.base.application.repository.DestinationRepository;
import com.internet.base.application.service.DestinationService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DestinationServiceImpl implements DestinationService {

    private DestinationRepository destinationRepository;

    public DestinationServiceImpl(final DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    @Override
    public long save(SaveDestinationRequest request) {
        var dbDestination = destinationRepository.findById(request.getId());
        if(dbDestination.isPresent()) {
            dbDestination.get().setName(request.getName());
            destinationRepository.save(dbDestination.get());
            return dbDestination.get().getId();
        }

        var newDestination = new Destination();
        newDestination.setName(request.getName());
        newDestination.setCreatedAt(new Date());
        destinationRepository.save(newDestination);
        return newDestination.getId();
    }

    @Override
    public List<Destination> getAll() {
        return destinationRepository.findAll();
    }

    @Override
    public Optional<Destination> getById(long id) {
        return destinationRepository.findById(id);
    }

    @Override
    public void delete(long destinationId) {
        var dbDestination = destinationRepository.findById(destinationId).orElseThrow(() -> new IllegalArgumentException("Invalid id"));
        destinationRepository.delete(dbDestination);
    }
}

