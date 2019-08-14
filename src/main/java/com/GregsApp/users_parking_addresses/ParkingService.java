package com.GregsApp.users_parking_addresses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ParkingService {

    private ParkingRepository parkingRepository;


    @Autowired
    public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    public void createParkingPlace(ParkingAddress parkingAddress){
        parkingRepository.save(parkingAddress);
    }
    public void updateParkingPlace(ParkingAddress parkingAddress){
        ParkingAddress parkingById = parkingRepository.findOneById(parkingAddress.getId());
        parkingRepository.save(parkingById);
    }
    public void deleteParkingById(ParkingAddress parkingAddressById){
        parkingRepository.delete(parkingAddressById);
    }

    public void updateParkingAddress(ParkingAddress parkingAddress){
        ParkingAddress parkingById = parkingRepository.findOneById(parkingAddress.getId());
        parkingRepository.save(parkingById);
    }
    public List<ParkingAddress> allParkingPlaces(){
        return parkingRepository.findAll();
    }
    public List<ParkingAddress> allParkingPlacesByStreetName(String streetName){
        List<ParkingAddress> allByStreet = parkingRepository.findAllByStreet(streetName);
        return allByStreet;
    }
    public List<ParkingAddress> allParkingPlacesByStreetNumber(Integer streetNumber){
        List<ParkingAddress> allByStreetNumber = parkingRepository.findAllByStreetNumber(streetNumber);
        return allByStreetNumber;
    }





}
