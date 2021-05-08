package com.internet.base.application.service.Impl;//package com.internet.base.com.internet.base.application.service.Impl;
//
//import com.internet.base.com.internet.base.application.model.Reservation;
//import com.internet.base.com.internet.base.application.model.Tour;
//import com.internet.base.com.internet.base.application.repository.ReservationRepository;
//import com.internet.base.com.internet.base.application.repository.TourRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import javax.validation.Valid;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Service
//public class ReservationService {
//    @Autowired
//    private ReservationRepository reservationRepository;
//
//    @Autowired
//    private TourRepository tourRepository;
//
//    public ResponseEntity<?> addOrder(Reservation reservation) {
//
//        Tour tour = tourRepository.findOne(reservation.getTour().getTourID());
//
//        if (tour != null) {
//
//            reservation.setCheckInDate(new Date());
//            reservation.setFinalPrice(tour.getPrice());
//            reservationRepository.save(reservation);
//
//            tourRepository.save(tour);
//
//            Map<String, Reservation> result = new HashMap<String, Reservation>();
//            result.put("Reservation created ", reservation);
//            return new ResponseEntity<Map<String, Reservation>>(result, HttpStatus.OK);
//        } else {
//            Map<String, Long> result = new HashMap<String, Long>();
//            result.put("Select a lower quantity, available tour for you ", tour.getQuantity());
//            return new ResponseEntity<Map<String, Long>>(result, HttpStatus.NOT_FOUND);
//        }
//    }
//
//    public List<Reservation> getReservation() {
//
//        return reservationRepository.findAll();
//    }
//
//    public ResponseEntity<?> updateReservation(Long ordersId, @Valid Reservation reservation) {
//        Reservation reservation1 = reservationRepository.findOne(ordersId);
//        if (reservation1 != null) {
//
//            //reservation1.setPrice(reservation.getPrice());
//            reservation1.setCheckInDate(new Date());
//
//            reservationRepository.save(reservation1);
//
//            Map<String, Reservation> result = new HashMap<String, Reservation>();
//            result.put("Orders Updated ", reservation1);
//            return new ResponseEntity<Map<String, Reservation>>(result, HttpStatus.OK);
//        } else {
//            Map<String, Long> result = new HashMap<String, Long>();
//            result.put("not found reservation1 with Id ", ordersId);
//            return new ResponseEntity<Map<String, Long>>(result, HttpStatus.NOT_FOUND);
//        }
//    }
//
//    public ResponseEntity<?> deleteReservation(Long reservationID) {
//        Reservation reservation = reservationRepository.findOne(reservationID);
//        if (reservation != null) {
//
//            reservationRepository.delete(reservation);
//
//            Map<String, Long> result = new HashMap<String, Long>();
//            result.put("Successfully deleted reservation with Id: ", reservationID);
//            return new ResponseEntity<Map<String, Long>>(result, HttpStatus.OK);
//
//        } else {
//            Map<String, Long> result = new HashMap<String, Long>();
//            result.put("not found reservation with Id ", reservationID);
//            return new ResponseEntity<Map<String, Long>>(result, HttpStatus.NOT_FOUND);
//        }
//    }
//
//    public ResponseEntity<?> getReservation(Long reservationID) {
//        Reservation reservation = reservationRepository.findOne(reservationID);
//        if (reservation != null) {
//
//            Map<String, Reservation> result = new HashMap<String, Reservation>();
//            result.put("Order found: ", reservation);
//            return new ResponseEntity<Map<String, Reservation>>(result, HttpStatus.OK);
//
//        } else {
//            Map<String, Long> result = new HashMap<String, Long>();
//            result.put("Not found reservation with Id ", reservationID);
//            return new ResponseEntity<Map<String, Long>>(result, HttpStatus.NOT_FOUND);
//        }
//    }
//
//    public ResponseEntity<?> getOrdersByDates(Reservation orders, String dateFrom, String dateTo) {
//        Map<String, String> result = new HashMap<String, String>();
//        result.put(dateFrom, dateTo);
//        return new ResponseEntity<Map<String, String>>(result, HttpStatus.OK);
//    }
//
//    public ResponseEntity<?> getOrdersBetweenDates(String date_from, String date_to, Reservation orders) {
//
//        if (date_from != null && date_to != null) {
//
//
//            List<Reservation> orders1 = reservationRepository.findallBetweenDates(date_from, date_to,orders.getUsers());
//            if (orders1 != null) {
//                Map<String, List<Reservation>> result = new HashMap<String, List<Reservation>>();
//                result.put("Orders between dates provided: ", orders1);
//                return new ResponseEntity<Map<String, List<Reservation>>>(result, HttpStatus.NOT_FOUND);
//            } else {
//                Map<String, String> result = new HashMap<String, String>();
//                result.put("Not found Orders between given  ", "Dates");
//                return new ResponseEntity<Map<String, String>>(result, HttpStatus.NOT_FOUND);
//            }
//        } else {
//            List<Reservation> reservation1 = reservationRepository.findAll();
//
//            Map<String, List<Reservation>> result = new HashMap<String, List<Reservation>>();
//            result.put("Select a lower quantity, available product for you ", reservation1);
//            return new ResponseEntity<Map<String, List<Reservation>>>(result, HttpStatus.NOT_FOUND);
//        }
//    }
//}
