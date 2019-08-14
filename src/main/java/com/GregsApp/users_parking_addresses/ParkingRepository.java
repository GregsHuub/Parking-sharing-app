package com.GregsApp.users_parking_addresses;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ParkingRepository extends JpaRepository<ParkingAddress, Long> {

    ParkingAddress findOneById(Long parkingId);
    List<ParkingRepository> findAllByStreet(String streetName);
    List<ParkingRepository> findAllByParkingName(String parkingName);
    List<ParkingRepository> findAllByStreetNumber(Integer streetNumber);
    List<ParkingRepository> findAllByReserved(boolean trueOrFalse);


}
