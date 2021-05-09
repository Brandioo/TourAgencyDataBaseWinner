package com.internet.base.application.service;


import com.internet.base.application.model.Tour;
import com.internet.base.application.service.Impl.TourImpl.SaveTourRequest;
import java.util.List;
import java.util.Optional;

public interface TourService {
    long save(SaveTourRequest request);
    List<Tour> getAll();
    Optional<Tour> getById(long id);
    void delete(long tourId);
}
