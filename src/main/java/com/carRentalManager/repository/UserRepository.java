package com.carRentalManager.repository;

import com.carRentalManager.model.Reservation;
import com.carRentalManager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Transactional
    @Modifying
    @Query("SELECT u FROM users u WHERE u.username = ?1")
    List<User> getUserByName(String username);
}
