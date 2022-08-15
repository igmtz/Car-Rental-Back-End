package com.carRentalManager.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="classes")
public class CarClass implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    @Column(name = "class")
    private String carClass;

    public CarClass() {
    }

    public CarClass(String carClass) {
        this.carClass = carClass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarClass() {
        return carClass;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    @Override
    public String toString() {
        return "CarClass{" +
                "id=" + id +
                ", carClass='" + carClass + '\'' +
                '}';
    }
}
