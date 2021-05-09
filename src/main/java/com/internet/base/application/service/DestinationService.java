package com.internet.base.application.service;

import com.internet.base.application.model.Destination;
import com.internet.base.application.service.Impl.DestinationImpl.SaveDestinationRequest;

import java.util.List;
import java.util.Optional;

public interface DestinationService {
    long save(SaveDestinationRequest request);
    List<Destination> getAll();
    Optional<Destination> getById(long id);
    void delete(long destinationId);
}
