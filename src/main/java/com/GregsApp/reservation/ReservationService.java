package com.GregsApp.reservation;

import com.GregsApp.user.User;
import com.GregsApp.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ReservationService {

    private ReservationRepository reservationRepository;
    private UserRepository userRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
    }

    public void createReservation() {
        Reservation reservation = new Reservation();
        reservationRepository.save(reservation);
    }

    public void createReservationDTO(ReservationCreateDto reservationCreateDto, User userId) {

        User userById = userRepository.findOneById(userId.getId());

        Reservation reservation = new Reservation();
        reservation.setCreatedOn(reservationCreateDto.getCreatedOn());
        reservation.setUpdatedOn(reservationCreateDto.getUpdatedOn());
        reservation.setHowManyTimesPlaceWasBooked(reservationCreateDto.getHowManyTimesPlaceWasBooked());
        reservation.setMinDurationTime(reservationCreateDto.getMinDurationTime());
        reservation.setPrice(reservationCreateDto.getPrice());
        reservation.setReservationHashId(reservationCreateDto.getReservationHashId());
        reservation.setServiceFee(reservationCreateDto.getServiceFee());
        reservation.setTimeFrom(reservationCreateDto.getTimeFrom());
        reservation.setTimeTo(reservationCreateDto.getTimeTo());
        reservation.setTotalPrice(reservationCreateDto.getTotalPrice());
        reservation.setUser(userById);

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
        reservation.setTimeFrom(reservationCreateDto.getTimeFrom());
        reservation.setTimeTo(reservationCreateDto.getTimeTo());
        reservation.setTotalPrice(reservationCreateDto.getTotalPrice());
    }
}
