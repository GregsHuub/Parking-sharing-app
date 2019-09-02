package com.GregsApp.reservation;


import com.GregsApp.parking_addresses.ParkingAddress;
import com.GregsApp.parking_addresses.ParkingService;
import com.GregsApp.security.CurrentUser;
import com.GregsApp.user.User;
import com.GregsApp.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/reservation")
public class ReservationController {

    private ReservationService reservationService;
    private ParkingService parkingService;
    private UserService userService;

    @Autowired
    public ReservationController(ReservationService reservationService, ParkingService parkingService, UserService userService) {
        this.reservationService = reservationService;
        this.parkingService = parkingService;
        this.userService = userService;
    }


    @GetMapping("/details")
    public String reservationDetailsForm(Model model,
                                         @RequestParam Long id) {
        ParkingAddress byId = parkingService.parkingById(id);
        model.addAttribute("parking", byId);
        model.addAttribute("reservation", new Reservation());
        return "reservation/details_form";
    }

//    @PostMapping("/details/save")
//    public String reservationSave(Model model,
//                                  @ModelAttribute("currentUser") User user,
//                                  @ModelAttribute Reservation reservation,
//                                  @RequestParam Long id) {
//        // TODO: 01.09.2019 Z USEREM JEST PROBLEM
//        ParkingAddress byId = parkingService.parkingById(id);
//        byId.setReserved(true);
//        model.addAttribute("parking", byId);
//        reservation.setMinDurationTime(300);
//        reservationService.createReservation(reservation, byId, user);
//        return "redirect:/reservation/details/save/confirmation";
//    }

    @PostMapping("/details/save")
    public String reservationSave(@ModelAttribute Reservation reservation,
                                  @RequestParam Long id) {

        ParkingAddress byId = parkingService.parkingById(id);
        byId.setReserved(false); // na czas testow zostawic false, potem zmienic na true
        //todo
        reservation.setMinDurationTime(300);
        reservationService.createReservationVersionSecond(reservation);
        return "redirect:/reservation/details/save/confirmation";
    }

//    CONFIRMATION REDIRECTIONS *******************   //
    @GetMapping("/details/save/confirmation")
    public String redirectConfirmation() {
        return "redirect:/reservation/success";
    }

    @GetMapping("/success")
    @ResponseBody
    public String reservationRedirectSuccess(@ModelAttribute("currentUser") User user) {
        return "użytkowniku: " + user.getEmail() + " zapisano w bazie danych twoja rezerwacje";
    }


}
