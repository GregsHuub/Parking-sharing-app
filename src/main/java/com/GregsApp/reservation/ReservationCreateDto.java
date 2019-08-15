package com.GregsApp.reservation;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class ReservationCreateDto {

    private LocalDateTime timeFrom;
    private LocalDateTime timeTo;
    private BigDecimal price;
    private BigDecimal serviceFee;
    private BigDecimal totalPrice;
    private Integer howManyTimesPlaceWasBooked; // couldnt find better name
    private Integer minDurationTime;
    private UUID reservationHashId;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private Long userId;


    public ReservationCreateDto(){

    }
    public ReservationCreateDto(Reservation reservation){
        this.timeFrom = reservation.getTimeFrom();
        this.timeTo = reservation.getTimeTo();
        this.price = reservation.getPrice();
        this.serviceFee = reservation.getServiceFee();
        this.totalPrice = reservation.getTotalPrice();
        this.howManyTimesPlaceWasBooked = reservation.getHowManyTimesPlaceWasBooked();
        this.minDurationTime = reservation.getMinDurationTime();
        this.reservationHashId = reservation.getReservationHashId();
        this.createdOn = reservation.getCreatedOn();
        this.updatedOn = reservation.getUpdatedOn();
        this.userId = reservation.getUser().getId();
    }

    @PrePersist
    public void prePersist() {
        createdOn = LocalDateTime.now().withSecond(0).withNano(0);
    }

    @PreUpdate
    public void preUpdate() {
        updatedOn = LocalDateTime.now().withSecond(0).withNano(0);
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

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
