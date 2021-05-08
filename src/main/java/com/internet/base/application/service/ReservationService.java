package com.internet.base.application.service;

import com.internet.base.application.model.Reservation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReservationService {

    public Reservation addReservation(Reservation reservation);

    public List<Reservation> getReservation();

    public ResponseEntity<?> getReservationById(Long reservationID);

    public ResponseEntity<?> updateReservation(Long reservationID, Reservation reservationRequest);

    public ResponseEntity<?> deleteReservation(Long reservationID);

}
