package com.GregsApp.order;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime timeFrom;
    private LocalDateTime timeTo;
    private BigDecimal price;
    private BigDecimal serviceFee;
    private BigDecimal totalPrice;
    private Integer howManyTimesPlaceWasBooked; // couldnt find better name
    private Integer minDurationTime; // minimum time to reserve
    private UUID reservationHashId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(LocalDateTime timeFrom) {
        this.timeFrom = timeFrom;
    }

    public LocalDateTime getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(LocalDateTime timeTo) {
        this.timeTo = timeTo;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(BigDecimal serviceFee) {
        this.serviceFee = serviceFee;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getHowManyTimesPlaceWasBooked() {
        return howManyTimesPlaceWasBooked;
    }

    public void setHowManyTimesPlaceWasBooked(Integer howManyTimesPlaceWasBooked) {
        this.howManyTimesPlaceWasBooked = howManyTimesPlaceWasBooked;
    }

    public Integer getMinDurationTime() {
        return minDurationTime;
    }

    public void setMinDurationTime(Integer minDurationTime) {
        this.minDurationTime = minDurationTime;
    }

    public UUID getReservationHashId() {
        return reservationHashId;
    }

    public void setReservationHashId(UUID reservationHashId) {
        this.reservationHashId = reservationHashId;
    }
}
