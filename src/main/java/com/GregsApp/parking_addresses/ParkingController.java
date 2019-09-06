package com.GregsApp.parking_addresses;

import com.GregsApp.nbpCurrencyApi.CurrencyJsonParsingService;
import com.GregsApp.reservation.Reservation;
import com.GregsApp.reservation.ReservationService;
import com.GregsApp.user.User;
import com.GregsApp.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/parking")
public class ParkingController {

    private ParkingService parkingService;
    private ParkingRepository parkingRepository;
    private CurrencyJsonParsingService currencyJsonParsingService;
    private UserRepository userRepository;
    private ReservationService reservationService;

    @Autowired
    public ParkingController(ParkingService parkingService, ParkingRepository parkingRepository, CurrencyJsonParsingService currencyJsonParsingService, UserRepository userRepository, ReservationService reservationService) {
        this.parkingService = parkingService;
        this.parkingRepository = parkingRepository;
        this.currencyJsonParsingService = currencyJsonParsingService;
        this.userRepository = userRepository;
        this.reservationService = reservationService;
    }

    //-------------    ADD PARKING VIEW ******START --------------//
    @GetMapping("/add_form")
    public String addParkingForm(Model model, @ModelAttribute("currentUser") User user) {
        model.addAttribute("parkingAddress", new ParkingAddress());
        return "parking/parking_add_form";
    }

    @PostMapping("/save")
    public String saveParking(@ModelAttribute ParkingAddress parkingAddress,
                              @RequestParam ("imageFile") MultipartFile imageFile,
                              @ModelAttribute Reservation reservation) throws IOException {

        parkingService.createParkingPlace(parkingAddress, imageFile);
        return "redirect:/parking/list";
    }
    //-------------    ADD PARKING VIEW *****FINISH --------------//


    //-------------    PARKING VIEW LIST   --------------//
    @GetMapping("/list")
    public String listOfParkings(Model model) {

        model.addAttribute("parkingAddresses", parkingService.allParkingPlaces());
        model.addAttribute("reservations", reservationService.reservationsList());
        return "parking/parking_list";
    }

    //-------------    PARKING FIND BY PARAMETER   --------------//
    @RequestMapping(value = "/list/search", method = RequestMethod.GET)
    public String foundAddressByStreetPart(@RequestParam("street") String street, Model model) {
        List<ParkingAddress> addressesByStreet = parkingService.allParkingsByPartStreetName(street);
        model.addAttribute("byStreet", addressesByStreet);
        return "parking/parking_search_success";
    }

}



