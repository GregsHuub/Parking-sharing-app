package com.GregsApp.users_parking_addresses;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingRepository extends JpaRepository<ParkingAddress, Long> {

    ParkingAddress findOneById(Long parkingId);
    ParkingAddress findAllByStreet(String streetName);
    ParkingAddress findAllByParkingName(String parkingName);
    ParkingAddress findAllByStreetNumber(Long streetNumber);

}
