package com.internet.base.application.service;

import com.internet.base.application.model.Reservation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReservationService {

    Reservation addReservation(Reservation reservation);

    List<Reservation> getReservation();

    ResponseEntity<?> getReservationById(Long reservationID);

    ResponseEntity<?> updateReservation(Long reservationID, Reservation reservationRequest);

    ResponseEntity<?> deleteReservation(Long reservationID);

}
