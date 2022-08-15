package com.carRentalManager.repository;

import com.carRentalManager.model.CarClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ClassRepository extends JpaRepository<CarClass, Integer> {

}
