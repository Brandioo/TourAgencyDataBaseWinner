package com.internet.base.application.controller;

import com.internet.base.application.model.Reservation;
import com.internet.base.application.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ReservationController {


    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/reservation")
    public Reservation addReservation(@RequestBody Reservation reservation) {
        return reservationService.addReservation(reservation);
    }

    @GetMapping("/reservations")
    public List<Reservation> getReservation() {
        return reservationService.getReservation();
    }

    @GetMapping("/reservation/{reservationID}")
    public ResponseEntity<?> getReservationById(Long reservationID) {
        return reservationService.getReservationById(reservationID);
    }


    @PutMapping("/reservation/{reservationID}")
    public ResponseEntity<?> updateReservation(@PathVariable Long reservationID, @Valid @RequestBody Reservation reservationRequest) {
        return reservationService.updateReservation(reservationID, reservationRequest);
    }


    @DeleteMapping("/reservation/{reservationID}")
    public ResponseEntity<?> deleteReservation(@PathVariable Long reservationID) {
        return reservationService.deleteReservation(reservationID);
    }
}
