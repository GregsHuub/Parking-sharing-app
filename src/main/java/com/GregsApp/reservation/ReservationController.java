package com.GregsApp.reservation;


import com.GregsApp.parking_addresses.ParkingAddress;
import com.GregsApp.parking_addresses.ParkingService;
import com.GregsApp.user.User;
import com.restfb.json.JsonObject;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/reservation")
public class ReservationController {

    private ReservationService reservationService;
    private ParkingService parkingService;

    @Autowired
    public ReservationController(ReservationService reservationService, ParkingService parkingService) {
        this.reservationService = reservationService;
        this.parkingService = parkingService;
    }

    @GetMapping("/details")
    public String reservationDetailsForm(Model model,
                                         @ModelAttribute("currentUser") User user,
                                         @RequestParam Long id){
        ParkingAddress byId = parkingService.parkingById(id);
        model.addAttribute("parking", byId);
        model.addAttribute("reservation", new Reservation());
        return "reservation/details_form";
    }


}
