package com.GregsApp.reservation;

import com.GregsApp.parking_addresses.ParkingAddress;
import com.GregsApp.parking_addresses.ParkingRepository;
import com.GregsApp.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ReservationService {

    private ReservationRepository reservationRepository;
    private UserRepository userRepository;
    private ParkingRepository parkingRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, UserRepository userRepository, ParkingRepository parkingRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.parkingRepository = parkingRepository;
    }

    public void createReservation(Reservation reservation) {
        reservation.setReservationHashId(UUID.randomUUID());
        reservationRepository.save(reservation);
    }

    public void updateReservation(Long id, ReservationCreateDto reservationCreateDto) {
        Reservation reservation = reservationRepository.findOneById(id);

        reservation.setUpdatedOn(reservationCreateDto.getUpdatedOn());
        reservation.setHowManyTimesPlaceWasBooked(reservationCreateDto.getHowManyTimesPlaceWasBooked());
        reservation.setMinDurationTime(reservationCreateDto.getMinDurationTime());
        reservation.setPrice(reservationCreateDto.getPrice());
        reservation.setReservationHashId(reservationCreateDto.getReservationHashId());
        reservation.setServiceFee(reservationCreateDto.getServiceFee());
        reservation.setTotalPrice(reservationCreateDto.getTotalPrice());
    }

    public Reservation findReservById(Long id) {
        return reservationRepository.findOneById(id);
    }

    public List<Reservation> reservationsList() {
        return reservationRepository.findAll();
    }

    public Reservation findByParking() {
        List<ParkingAddress> allParkings = parkingRepository.findAll();
        List<Reservation> allReservations = reservationRepository.findAll();

        for (ParkingAddress p : allParkings) {
            for (Reservation r : allReservations) {
                if (p.getId().equals(r.getParkingAddress().getId())) {
                    return r;
                }
            }
        }
        return null;
    }


}
