package com.carRentalManager.controller;

import com.carRentalManager.exception.CarNotFoundException;
import com.carRentalManager.model.Car;
import com.carRentalManager.model.Reservation;
import com.carRentalManager.repository.CarRepository;
import com.carRentalManager.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping("/getAll")
    public ResponseEntity<List<Car>> getAllReservations() {
        List<Car> cars = carRepository.findAll();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }


    @GetMapping("/getAvailable")
    public ResponseEntity<List<Car>> getAvailableCars(Date from, Date to) {
        List<Car> cars = carRepository.findAll();

        List<Reservation> reservations = reservationRepository.findAll();
        for (Reservation r: reservations) {
            int carId = r.getCar_id();
            for (Car c: cars) {
                c = carRepository.findById(carId).orElseThrow(
                        () -> new CarNotFoundException("The car with the id " + carId + " was not found")
                );
                if (carId == c.getId()) {
                    if ((r.getFrom_date().after(from) && r.getFrom_date().after(to)) || (r.getTo_date().before(from) && (r.getTo_date().before(to)))) {
                        carRepository.setAvailableTrue(c.getId());
                    } else {
                        carRepository.setAvailableFalse(c.getId());
                    }
                } else {
                    carRepository.setAvailableTrue(c.getId());
                }
            }
        }

        List<Car> carsUpdated = carRepository.findAll();
        List<Car> availableCars = new ArrayList<>();

        for (Car c: carsUpdated) {
            if (c.isAvailable() && c.isReturned()){
                availableCars.add(c);
            }
        }
        return new ResponseEntity<>(availableCars, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable("id") int id) {
        Car car = carRepository.findById(id).orElseThrow(
                () -> new CarNotFoundException("The car with the id " + id + " was not found")
        );
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @GetMapping("/findByClass/{id}")
    public ResponseEntity<List<Car>> findCarByClass(@PathVariable("id") int classId) {
        List<Car> cars = carRepository.findByClass(classId);
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/findByModel/{id}")
    public ResponseEntity<List<Car>> findCarByModel(@PathVariable("id") int modelId) {
        List<Car> cars = carRepository.findByModel(modelId);
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/findByPrice")
    public ResponseEntity<List<Car>> findCarByPrice(BigDecimal from, BigDecimal to) {
        List<Car> cars = carRepository.findByPrice(from, to);
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @PutMapping("/pickCar/{id}")
    public ResponseEntity<Car> pickCarById (@PathVariable("id") int id) {
        Car car = carRepository.findById(id).orElseThrow(
                () -> new CarNotFoundException("The car with the id " + id + " was not found")
        );
        carRepository.pickCar(car.getId());
        Car carUpdated = carRepository.findById(id).orElseThrow(
                () -> new CarNotFoundException("The car with the id " + id + " was not found")
        );
        return new ResponseEntity<>(carUpdated, HttpStatus.OK);
    }

    @PutMapping("/returnCar/{id}")
    public ResponseEntity<Car> returnCarById (@PathVariable("id") int id) {
        Car car = carRepository.findById(id).orElseThrow(
                () -> new CarNotFoundException("The car with the id " + id + " was not found")
        );
        carRepository.returnCar(car.getId());
        Car carUpdated = carRepository.findById(id).orElseThrow(
                () -> new CarNotFoundException("The car with the id " + id + " was not found")
        );
        return new ResponseEntity<>(carUpdated, HttpStatus.OK);
    }



}
