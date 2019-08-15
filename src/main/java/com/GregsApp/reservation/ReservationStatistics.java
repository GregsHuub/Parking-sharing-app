package com.GregsApp.reservation;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class ReservationStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer reservationsSumCount;
    private Double reservationsAvgCount;
    private LocalDateTime lastReservationTime;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getReservationsSumCount() {
        return reservationsSumCount;
    }

    public void setReservationsSumCount(Integer reservationsSumCount) {
        this.reservationsSumCount = reservationsSumCount;
    }

    public Double getReservationsAvgCount() {
        return reservationsAvgCount;
    }

    public void setReservationsAvgCount(Double reservationsAvgCount) {
        this.reservationsAvgCount = reservationsAvgCount;
    }

    public LocalDateTime getLastReservationTime() {
        return lastReservationTime;
    }

    public void setLastReservationTime(LocalDateTime lastReservationTime) {
        this.lastReservationTime = lastReservationTime;
    }
}
