package com.GregsApp.reservation;

import com.GregsApp.parking_addresses.ParkingAddress;
import com.GregsApp.user.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate timeFromDATE;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate timeToDATE;
    @DateTimeFormat(pattern = "hh:mm")
    private LocalTime timeFromHOURS;
    @DateTimeFormat(pattern = "hh:mm")
    private LocalTime timeToHOURS;
    private BigDecimal price;
    private BigDecimal serviceFee;
    private BigDecimal totalPrice;
    private Integer howManyTimesPlaceWasBooked; // couldnt find better name
    private Integer minDurationTime; // minimum time to reserve
    private UUID reservationHashId;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "parking_id", nullable = false)
    private ParkingAddress parkingAddress;


    @PrePersist
    public void prePersist() {
        createdOn = LocalDateTime.now().withSecond(0).withNano(0);
    }

    @PreUpdate
    public void preUpdate() {
        updatedOn = LocalDateTime.now().withSecond(0).withNano(0);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getTimeFromDATE() {
        return timeFromDATE;
    }

    public void setTimeFromDATE(LocalDate timeFromDATE) {
        this.timeFromDATE = timeFromDATE;
    }

    public LocalDate getTimeToDATE() {
        return timeToDATE;
    }

    public void setTimeToDATE(LocalDate timeToDATE) {
        this.timeToDATE = timeToDATE;
    }

    public LocalTime getTimeFromHOURS() {
        return timeFromHOURS;
    }

    public void setTimeFromHOURS(LocalTime timeFromHOURS) {
        this.timeFromHOURS = timeFromHOURS;
    }

    public LocalTime getTimeToHOURS() {
        return timeToHOURS;
    }

    public void setTimeToHOURS(LocalTime timeToHOURS) {
        this.timeToHOURS = timeToHOURS;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ParkingAddress getParkingAddress() {
        return parkingAddress;
    }

    public void setParkingAddress(ParkingAddress parkingAddress) {
        this.parkingAddress = parkingAddress;
    }
}
