package com.GregsApp.parking_addresses;

import com.GregsApp.exceptions.FileStorageException;
import com.GregsApp.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class ParkingService {

    private ParkingRepository parkingRepository;
    private UserRepository userRepository;


    @Autowired
    public ParkingService(ParkingRepository parkingRepository, UserRepository userRepository) {
        this.parkingRepository = parkingRepository;
        this.userRepository = userRepository;
    }


    public void updateParkingPlace(ParkingAddress parkingAddress) {
        ParkingAddress parkingById = parkingRepository.findOneById(parkingAddress.getId());
        parkingRepository.save(parkingById);
    }

    public void deleteParkingById(ParkingAddress parkingAddressById) {
        parkingRepository.delete(parkingAddressById);
    }

    public void updateParkingAddress(ParkingAddress parkingAddress) {
        ParkingAddress parkingById = parkingRepository.findOneById(parkingAddress.getId());
        parkingRepository.save(parkingById);
    }

    public List<ParkingAddress> allParkingPlaces() {
        return parkingRepository.findAll();
    }

    public List<ParkingAddress> allParkingPlacesByStreetName(String streetName) {
        return parkingRepository.findAllByStreet(streetName);
    }

    public List<ParkingAddress> allParkingPlacesByStreetNumber(Integer streetNumber) {
        return parkingRepository.findAllByStreetNumber(streetNumber);
    }

    public List<ParkingAddress> allParkingsByPartStreetName(String streetLetters) {
        return parkingRepository.findAllByStreetContaining(streetLetters);
    }

    //    IMAGE     //
    public void createParkingPlace(ParkingAddress parkingAddress) {

        parkingRepository.save(parkingAddress);
    }



}
