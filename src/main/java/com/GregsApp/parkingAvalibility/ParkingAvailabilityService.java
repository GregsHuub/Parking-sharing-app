package com.GregsApp.parkingAvalibility;

import com.GregsApp.parking_addresses.ParkingAddress;
import com.GregsApp.parking_addresses.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class ParkingAvailabilityService {


    private ParkingAvabilityRepository PAR;
    private ParkingRepository parkingRepository;

    @Autowired
    public ParkingAvailabilityService(ParkingAvabilityRepository PAR, ParkingRepository parkingRepository) {
        this.PAR = PAR;
        this.parkingRepository = parkingRepository;
    }

    public void setParkingAvabilityStatus(Long parkingAddressById, boolean turnOnAvability){
        ParkingAddress parkingById = parkingRepository.findOneById(parkingAddressById);
        ParkingAvailability oneById = PAR.findOneById(parkingById.getId());
        oneById.setUpdateStatusTime(LocalDateTime.now());
        oneById.setAvailabilityNow(turnOnAvability);
    }
    public List<ParkingAvailability> getAllListOfParkAvaib(){
        return PAR.findAll();
    }
    public List<ParkingAvailability> getParkingAvabilityByDate(Date from, Date to){
        return PAR.findAllByAvabilityParkingTimeSetByOwnerBetween(from, to);
    }
    public List<ParkingAvailability> getParkingAvabilityByStatus(boolean findByAvabilityStatus){
        return PAR.findAllByAvailabilityNow(findByAvabilityStatus);
    }
    // todo rozkminic czy to tak zadzial
    public ParkingAvailability createParkingWithAvability(ParkingAddress parkingAddress){
        ParkingAvailability oneById = PAR.findOneById(parkingAddress.getId());
        return PAR.save(oneById);
    }
}
