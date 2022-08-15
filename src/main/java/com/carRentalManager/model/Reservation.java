package com.carRentalManager.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

@Entity(name = "reservations")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private int id;
    @Column(name = "car_id")
    private int car_id;
    @Column(name = "reservation_code", nullable = false, updatable = false)
    private String reservation_code;
    @Column(name = "from_date")
    private Date from_date;
    @Column(name = "to_date")
    private Date to_date;
    @Column(name = "user_id")
    private int user_id;
    @Column(name = "total_price")
    private BigDecimal total_price;

    public Reservation() {
    }

    public Reservation(int car_id, String reservation_code, Date from_date, Date to_date, int user_id, BigDecimal total_price) {
        this.car_id = car_id;
        this.from_date = from_date;
        this.to_date = to_date;
        this.user_id = user_id;
        this.total_price = total_price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public String getReservation_code() {
        return reservation_code;
    }

    public void setReservation_code(String reservation_code) {
        this.reservation_code = reservation_code;
    }

    public Date getFrom_date() {
        return from_date;
    }

    public void setFrom_date(Date from_date) {
        this.from_date = from_date;
    }

    public Date getTo_date() {
        return to_date;
    }

    public void setTo_date(Date to_date) {
        this.to_date = to_date;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public BigDecimal getTotal_price() {
        return total_price;
    }

    public void setTotal_price(BigDecimal total_price) {
        this.total_price = total_price;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", car_id=" + car_id +
                ", reservation_code='" + reservation_code + '\'' +
                ", from_date=" + from_date +
                ", to_date=" + to_date +
                ", user_id=" + user_id +
                ", total_price=" + total_price +
                '}';
    }
}
