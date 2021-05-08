package com.internet.base.application.service.Impl;

import com.internet.base.application.model.Tour;
import com.internet.base.application.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TourService {
    @Autowired
    private TourRepository tourRepository;

    public ResponseEntity<?> addTour(Tour tour) {

        Tour tour1 = tourRepository.findOne(tour.getId());

        if (tour1 != null) {

            int product_Quantity = tour1.getQuantity();
            int Quantity_To_be_Added = tour.getQuantity();
            int total = product_Quantity + Quantity_To_be_Added;

            tour1.setQuantity(total);

            Tour newProduct = tourRepository.save(tour1);

            Map<String, Tour> result = new HashMap<String, Tour>();
            result.put("Tours Added ", newProduct);
            return new ResponseEntity<Map<String, Tour>>(result, HttpStatus.OK);
        } else {
            Tour newTour = new Tour();
//            newTour.setDeviceType(tour.getDeviceType());
            newTour.setId(tour.getId());
            newTour.setDays(tour.getDays());
            newTour.setDeparture(tour.getDeparture());
            newTour.setDescription(tour.getDescription());
            newTour.setFeatured(tour.isFeatured());
            newTour.setMaxPeople(tour.getMaxPeople());
            newTour.setMinPeople(tour.getMinPeople());
            newTour.setPhoto(tour.getPhoto());
//            newTour.setUsers(tour.getUsers());
            newTour.setPrice(tour.getPrice());
            newTour.setTitle(tour.getTitle());
            newTour.setDestination(tour.getDestination());
            newTour.setQuantity(tour.getQuantity());
            tourRepository.save(newTour);

            Map<String, Tour> result = new HashMap<String, Tour>();
            result.put("Tour Added", newTour);
            return new ResponseEntity<Map<String, Tour>>(result, HttpStatus.OK);
        }

    }

    public List<Tour> getTour() {
        return tourRepository.findAll();

    }

    public ResponseEntity<?> updateTour(Long tourID, @Valid Tour tour) {
        if (tour != null) {
            Tour tour1 = tourRepository.findOne(tourID);
            if (tour1 != null) {

                tour1.setDescription(tour.getDescription());

                tourRepository.save(tour1);

                Map<String, Tour> result = new HashMap<String, Tour>();
                result.put("Tour Updated ", tour1);
                return new ResponseEntity<Map<String, Tour>>(result, HttpStatus.OK);
            } else {
                Map<String, Long> result = new HashMap<String, Long>();
                result.put("not found Tour with Id ", tourID);
                return new ResponseEntity<Map<String, Long>>(result, HttpStatus.NOT_FOUND);
            }
        } else {
            Map<String, String> result = new HashMap<String, String>();
            result.put("not input body ", "");
            return new ResponseEntity<Map<String, String>>(result, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleteTour(Long tourID) {
        Tour tour1 = tourRepository.findOne(tourID);
        if (tour1 != null) {

            tourRepository.delete(tour1);

            Map<String, Long> result = new HashMap<String, Long>();
            result.put("Successfully deleted Tour with Id: ", tourID);
            return new ResponseEntity<Map<String, Long>>(result, HttpStatus.OK);

        } else {
            Map<String, Long> result = new HashMap<String, Long>();
            result.put("not found Tour with Id ", tourID);
            return new ResponseEntity<Map<String, Long>>(result, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> getTourById(Long tourID) {
        Tour product = tourRepository.findOne(tourID);

        if (product != null) {

            Map<String, Tour> result = new HashMap<String, Tour>();
            result.put("Tour found: ", product);
            return new ResponseEntity<Map<String, Tour>>(result, HttpStatus.OK);

        } else {
            Map<String, Long> result = new HashMap<String, Long>();
            result.put("not found Tour with Id ", tourID);
            return new ResponseEntity<Map<String, Long>>(result, HttpStatus.NOT_FOUND);
        }
    }
}
