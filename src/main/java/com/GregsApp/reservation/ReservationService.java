package com.GregsApp.reservation;

import com.GregsApp.parking_addresses.ParkingAddress;
import com.GregsApp.parking_addresses.ParkingRepository;
import com.GregsApp.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
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

//    public Long countHoursBetweenDate(LocalDate from, LocalDate to){
//        return Duration.between(from,to).toDays();
//    }
//    public Long countDaysBetweenDate(LocalDate from, LocalDate to){
//        return Duration.between(from, to). toHours();
//    }

    public Long datesBetweenReservationDays(LocalDate dateFrom, LocalDate dateTo){
        Duration duration = Duration.between(dateFrom,dateTo);

        return Math.abs(duration.toMinutes());

    }
    public Long dateBetweenReservationHours(LocalTime timeFrom, LocalTime timeTo){
        Duration duration = Duration.between(timeFrom, timeTo);

        return Math.abs(duration.toMinutes());
    }



}
