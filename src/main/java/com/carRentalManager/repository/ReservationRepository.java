package com.carRentalManager.repository;

import com.carRentalManager.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer>, CrudRepository<Reservation, Integer> {

    @Transactional
    @Modifying
    @Query("SELECT r FROM reservations r WHERE r.reservation_code = ?1")
    List<Reservation> getReservationByCode(String username);

}
