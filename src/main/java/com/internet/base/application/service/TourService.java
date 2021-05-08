package com.internet.base.application.service;

import com.internet.base.application.model.Tour;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TourService {

    public Tour addTour(Tour tours);

    public List<Tour> getTours();

    public ResponseEntity<?> getTourById(Long tourID);

    public ResponseEntity<?> updateTour(Long tourID, Tour tourRequest);

    public ResponseEntity<?> deleteTour(Long tourID);

}
