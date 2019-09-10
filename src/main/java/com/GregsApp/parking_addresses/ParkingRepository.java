package com.GregsApp.parking_addresses;

import com.GregsApp.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParkingRepository extends JpaRepository<ParkingAddress, Long> {

    ParkingAddress findOneById(Long parkingId);
    ParkingAddress findOneByUser(User user);
    List<ParkingAddress> findAllByUser(User user);
    List<ParkingAddress> findAllByStreet(String streetName);
    List<ParkingAddress> findAllByParkingName(String parkingName);
    List<ParkingAddress> findAllByStreetNumber(Integer streetNumber);
    List<ParkingAddress> findAllByReserved(boolean trueOrFalse);
    List<ParkingAddress> findAllByMaxHeightBetween(Double valueFrom, Double valueTO);
    List<ParkingAddress> findAllByMaxWidthBetween(Double valueFrom, Double valueTO);
    List<ParkingAddress> findAllByStreetContaining(String containValue);




}
