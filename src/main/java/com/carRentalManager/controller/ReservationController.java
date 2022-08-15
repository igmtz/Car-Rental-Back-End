package com.carRentalManager.controller;

import com.carRentalManager.model.Reservation;
import com.carRentalManager.model.Car;
import com.carRentalManager.repository.CarRepository;
import com.carRentalManager.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.persistence.Query;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private CarRepository carRepository;

    @GetMapping("/getAll")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @PostMapping("/addReservation")
    public ResponseEntity<Reservation> addReservation (@RequestBody Reservation reservation) {
//        carRepository.updateAvailableCar(reservation.getCar_id());
//        carRepository.pickCar(reservation.getCar_id());
        reservation.setReservation_code(UUID.randomUUID().toString());
        Reservation newReservation = reservationRepository.save(reservation);
        return new ResponseEntity<>(newReservation, HttpStatus.CREATED);
    }

    @GetMapping("/findByReservationCode")
    public ResponseEntity<List<Reservation>> findReservationByReservationCode(String code) {
        List<Reservation> reservation = reservationRepository.getReservationByCode(code);
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }

}
