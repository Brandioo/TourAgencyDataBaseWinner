package com.internet.base.application.service.Impl.TourImpl;

import com.internet.base.application.model.TravelType;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class SaveTourRequest {

    private long id;
    private String title;
    private int days;
    private int maxPeople;
    private int minPeople;
    private String description;
    private String departure;
    private String photo;
    private boolean featured;
    @Enumerated(EnumType.STRING)
    private TravelType travelType;
    private int price;
    private int quantity;

}
