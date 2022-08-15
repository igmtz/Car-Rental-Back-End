package com.carRentalManager.repository;

import com.carRentalManager.model.Car;
import com.carRentalManager.model.Reservation;
import com.carRentalManager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public interface CarRepository  extends JpaRepository<Car, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE cars c SET c.available = false WHERE c.id = ?1")
    int setAvailableFalse(int car_id);

    @Transactional
    @Modifying
    @Query("UPDATE cars c SET c.available = true WHERE c.id = ?1")
    int setAvailableTrue(int car_id);

    @Transactional
    @Modifying
    @Query("UPDATE cars c SET c.returned = false WHERE c.id = ?1")
    int pickCar(int car_id);

    @Transactional
    @Modifying
    @Query("UPDATE cars c SET c.returned = true WHERE c.id = ?1")
    int returnCar(int car_id);

    @Transactional
    @Modifying
    @Query("SELECT c FROM cars c WHERE c.class_id = ?1 AND c.available = true")
    List<Car> findByClass(int classId);

    @Transactional
    @Modifying
    @Query("SELECT c FROM cars c WHERE c.model_id = ?1 AND c.available = true")
    List<Car> findByModel(int modelId);

    @Transactional
    @Modifying
    @Query("SELECT c FROM cars c WHERE c.price_per_day >= ?1 AND price_per_day <= ?2 AND c.available = true")
    List<Car> findByPrice(BigDecimal from, BigDecimal to);


}
