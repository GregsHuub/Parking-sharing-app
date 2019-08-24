package com.GregsApp.users_parking_addresses;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface ParkingRepository extends JpaRepository<ParkingAddress, Long> {

    ParkingAddress findOneById(Long parkingId);
    List<ParkingAddress> findAllByStreet(String streetName);
    List<ParkingAddress> findAllByParkingName(String parkingName);
    List<ParkingAddress> findAllByStreetNumber(Integer streetNumber);
    List<ParkingAddress> findAllByReserved(boolean trueOrFalse);
    List<ParkingAddress> findAllByMaxHeightBetween(Double valueFrom, Double valueTO);
    List<ParkingAddress> findAllByMaxWidthBetween(Double valueFrom, Double valueTO);




}
