package com.internet.base.application.controller;

import com.internet.base.application.model.Tour;
import com.internet.base.application.service.TourService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class TourController{


    private TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @PostMapping("/tour")
    public Tour addTour(@RequestBody Tour tour) {
        return tourService.addTour(tour);
    }

    @GetMapping("/tours")
    public List<Tour> getTours() {
        return tourService.getTours();
    }


    @GetMapping("/tour/{tourID}")
    public ResponseEntity<?> getTourById(Long tourID) {
        return tourService.getTourById(tourID);
    }


    @PutMapping("/tour/{tourID}")
    public ResponseEntity<?> updateTour(@PathVariable Long tourID, @Valid @RequestBody Tour tourRequest) {
        return tourService.updateTour(tourID, tourRequest);
    }


    @DeleteMapping("/tour/{tourID}")
    public ResponseEntity<?> deleteTour(@PathVariable Long tourID) {
        return tourService.deleteTour(tourID);
    }

}
