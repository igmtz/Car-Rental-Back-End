package com.carRentalManager.repository;

import com.carRentalManager.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface ModelRepository extends JpaRepository<Model, Integer> {
}
