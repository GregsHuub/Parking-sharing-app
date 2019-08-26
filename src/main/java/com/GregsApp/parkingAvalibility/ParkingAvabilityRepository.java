package com.GregsApp.parkingAvalibility;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ParkingAvabilityRepository extends JpaRepository<ParkingAvailability, Long> {

        List<ParkingAvailability> findAllByAvabilityParkingTimeSetByOwnerBetween(Date timeFrom, Date timeTo);

        List<ParkingAvailability> findAllByAvailabilityNow(boolean availableOrNot);

        ParkingAvailability findOneById(Long id);
}
