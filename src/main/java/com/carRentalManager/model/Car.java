package com.carRentalManager.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity(name = "cars")
public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    @Column(name = "model_id")
    private int model_id;

    @Column(name = "class_id")
    private int class_id;

    @Column(name = "price_per_day")
    private BigDecimal price_per_day;

    @Column(name = "seats")
    private int seats;

    @Column(name = "available")
    private boolean available;

    @Column(name = "returned")
    private boolean returned;

    @Column(name = "image")
    private String image;

    @Column(name = "car_name")
    private String car_name;

    public Car() {
    }



    public Car(int model_id, int class_id, BigDecimal price_per_day, int seats, boolean available, boolean returned, String image, String car_name) {
        this.model_id = model_id;
        this.class_id = class_id;
        this.price_per_day = price_per_day;
        this.seats = seats;
        this.available = available;
        this.returned = returned;
        this.image = image;
        this.car_name = car_name;
    }

    public String getCar_name() {
        return car_name;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getModel_id() {
        return model_id;
    }

    public void setModel_id(int model_id) {
        this.model_id = model_id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public BigDecimal getPrice_per_day() {
        return price_per_day;
    }

    public void setPrice_per_day(BigDecimal price_per_day) {
        this.price_per_day = price_per_day;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model_id=" + model_id +
                ", class_id=" + class_id +
                ", price_per_day=" + price_per_day +
                ", seats=" + seats +
                ", available=" + available +
                ", returned=" + returned +
                ", car_name=" + car_name +
                ", image='" + image + '\'' +
                '}';
    }
}
