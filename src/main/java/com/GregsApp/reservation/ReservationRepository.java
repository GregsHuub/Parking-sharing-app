package com.GregsApp.reservation;

import com.GregsApp.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Reservation findOneById(Long id);
    Reservation findOneByUserId(User userId);
    List<Reservation> findAllByUserId(User userId);
    List<Reservation> findAll();
}
