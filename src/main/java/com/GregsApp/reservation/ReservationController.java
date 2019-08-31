package com.GregsApp.reservation;

import com.GregsApp.parking_addresses.ParkingAddress;
import com.GregsApp.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReservationController {

    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }}

//    @PostMapping
//    @ResponseBody
//    public String reservationTest(@ModelAttribute Reservation reservation,
//                                  @RequestParam("parking") ParkingAddress parkingAddress,
//                                  @RequestParam("user") User user){
//        reservationService.createReservation(reservation, parkingAddress, user);
//        return "success " + reservation;
//
//    }
//}
