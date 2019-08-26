package com.GregsApp.users_parking_addresses;

import com.GregsApp.user.User;
import com.GregsApp.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ParkingService {

    private ParkingRepository parkingRepository;
    private UserRepository userRepository;


    @Autowired
    public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    public void createParkingPlace(ParkingAddress parkingAddress)
    {
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
        return parkingRepository.findAllByStreet(streetName);
    }
    public List<ParkingAddress> allParkingPlacesByStreetNumber(Integer streetNumber){
        return parkingRepository.findAllByStreetNumber(streetNumber);
    }
    public List<ParkingAddress> allParkingsByPartStreetName(String streetLetters){
         return parkingRepository.findAllByStreetContaining(streetLetters);
    }

    public List<ParkingAddress> allParkingsByDateBetween(Date dateFrom, Date dateTo){

    }





}
