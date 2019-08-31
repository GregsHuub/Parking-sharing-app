package com.GregsApp.parking_addresses;

import com.GregsApp.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    public void createParkingPlace(ParkingAddress parkingAddress, MultipartFile imageFile) throws IOException {
        Path currentPath = Paths.get(".");
        Path absolutePath = currentPath.toAbsolutePath();
        parkingAddress.setPath(absolutePath + "/src/main/resources/static/uploadPhotos/");
        parkingAddress.setFileName(imageFile.getOriginalFilename());
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(parkingAddress.getPath() + imageFile.getOriginalFilename());
        Files.write(path, bytes);

        parkingRepository.save(parkingAddress);
    }


}
