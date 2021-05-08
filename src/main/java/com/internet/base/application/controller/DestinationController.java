package com.internet.base.application.controller;

import com.internet.base.application.model.Destination;
import com.internet.base.application.service.DestinationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class DestinationController {


    private DestinationService destinationService;

    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @PostMapping("/destinations")
    public Destination addDestination(@RequestBody Destination destination) {
        return destinationService.addDestination(destination);
    }

    @GetMapping("/destinations")
    public List<Destination> getDestination() {
        return destinationService.getDestination();
    }

    @GetMapping("/destinations/{destinationID}")
    public ResponseEntity<?> getDestinationById(@PathVariable Integer destinationID) {
        return destinationService.getDestinationById(destinationID);
    }

    @PutMapping("/destinations/{destinationID}")
    public ResponseEntity<?> updateDestination(@PathVariable Integer destinationID, @Valid @RequestBody Destination destinationRequest) {
        return destinationService.updateDestination(destinationID, destinationRequest);
    }

    @DeleteMapping("/destinations/{destinationID}")
    public ResponseEntity<?> deleteDestination(@PathVariable Integer destinationID) {
        return destinationService.deleteDestination(destinationID);
    }
}
