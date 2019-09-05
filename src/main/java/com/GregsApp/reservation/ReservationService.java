package com.GregsApp.reservation;

import com.GregsApp.parking_addresses.ParkingAddress;
import com.GregsApp.parking_addresses.ParkingRepository;
import com.GregsApp.user.User;
import com.GregsApp.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@Transactional
public class ReservationService {

    private ReservationRepository reservationRepository;
    private UserRepository userRepository;
    private ParkingRepository parkingRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
    }

    public void createReservation(Reservation reservation, ParkingAddress parkingAddress, User user) {
        reservation.setParkingAddress(parkingAddress);
        reservation.setUser(user);
        reservation.setCreatedOn(LocalDateTime.now());
        reservationRepository.save(reservation);
    }
    public void createReservationVersionSecond(Reservation reservation){
        reservationRepository.save(reservation);
    }


    public void updateReservation(Long id, ReservationCreateDto reservationCreateDto){
        Reservation reservation = reservationRepository.findOneById(id);

        reservation.setUpdatedOn(reservationCreateDto.getUpdatedOn());
        reservation.setHowManyTimesPlaceWasBooked(reservationCreateDto.getHowManyTimesPlaceWasBooked());
        reservation.setMinDurationTime(reservationCreateDto.getMinDurationTime());
        reservation.setPrice(reservationCreateDto.getPrice());
        reservation.setReservationHashId(reservationCreateDto.getReservationHashId());
        reservation.setServiceFee(reservationCreateDto.getServiceFee());
//        reservation.setTimeFrom(reservationCreateDto.getTimeFrom());
//        reservation.setTimeTo(reservationCreateDto.getTimeTo());
        reservation.setTotalPrice(reservationCreateDto.getTotalPrice());
    }

    public ParkingRepository getParkingRepository() {
        return parkingRepository;
    }

    public void setParkingRepository(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }
}
