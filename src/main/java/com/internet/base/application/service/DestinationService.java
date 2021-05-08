package com.internet.base.application.service;

import com.internet.base.application.model.Destination;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DestinationService {
    public Destination addDestination(Destination destination);

    public List<Destination> getDestination();

    public ResponseEntity<?> getDestinationById(Integer destinationID);

    public ResponseEntity<?> updateDestination(Integer destinationID, Destination destinationRequest);

    public ResponseEntity<?> deleteDestination(Integer destinationID);
}
