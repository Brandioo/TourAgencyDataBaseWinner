package com.internet.base.application.service.Impl;

import com.internet.base.application.model.Destination;
import com.internet.base.application.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DestinationService {

    @Autowired
    private DestinationRepository destinationRepository;

    public ResponseEntity<?> addDestination(Destination destination) {

        Destination destination1 = destinationRepository.findOne(destination.getDestinationID());


        Destination newDestination = new Destination();
//            newDestination.setDeviceType(destination.getDeviceType());
        newDestination.setDestinationID(destination.getDestinationID());
        newDestination.setName(destination.getName());
//        newDestination.setTour(destination.getTour());
        destinationRepository.save(newDestination);

        Map<String, Destination> result = new HashMap<String, Destination>();
        result.put("Destination Added", newDestination);
        return new ResponseEntity<Map<String, Destination>>(result, HttpStatus.OK);
    }

    public List<Destination> getDestination() {

        return destinationRepository.findAll();
    }

    public ResponseEntity<?> updateDestination(Long destinationID, @Valid Destination reservation) {
        Destination destination = destinationRepository.findOne(destinationID);
        if (destination != null) {

            //destination.setPrice(reservation.getPrice());

            destinationRepository.save(destination);

            Map<String, Destination> result = new HashMap<String, Destination>();
            result.put("Destination Updated ", destination);
            return new ResponseEntity<Map<String, Destination>>(result, HttpStatus.OK);
        } else {
            Map<String, Long> result = new HashMap<String, Long>();
            result.put("not found Destination with Id ", destinationID);
            return new ResponseEntity<Map<String, Long>>(result, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleteDestination(Long destinationID) {
        Destination destination = destinationRepository.findOne(destinationID);
        if (destination != null) {

            destinationRepository.delete(destination);

            Map<String, Long> result = new HashMap<String, Long>();
            result.put("Successfully deleted Destination with Id: ", destinationID);
            return new ResponseEntity<Map<String, Long>>(result, HttpStatus.OK);

        } else {
            Map<String, Long> result = new HashMap<String, Long>();
            result.put("not found Destination with Id ", destinationID);
            return new ResponseEntity<Map<String, Long>>(result, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> getDestination(Long destinationID) {
        Destination destination = destinationRepository.findOne(destinationID);
        if (destination != null) {

            Map<String, Destination> result = new HashMap<String, Destination>();
            result.put("Destination found: ", destination);
            return new ResponseEntity<Map<String, Destination>>(result, HttpStatus.OK);

        } else {
            Map<String, Long> result = new HashMap<String, Long>();
            result.put("Not found Destination with Id ", destinationID);
            return new ResponseEntity<Map<String, Long>>(result, HttpStatus.NOT_FOUND);
        }
    }
}

