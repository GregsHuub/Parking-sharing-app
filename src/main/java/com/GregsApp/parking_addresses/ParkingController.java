package com.GregsApp.parking_addresses;

import com.GregsApp.nbpCurrencyApi.CurrencyJsonParsingService;
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

@Controller
@RequestMapping("/parking")
public class ParkingController {

    private ParkingService parkingService;
    private ParkingRepository parkingRepository;
    private CurrencyJsonParsingService currencyJsonParsingService;
    private UserRepository userRepository;

    @Autowired
    public ParkingController(ParkingService parkingService, ParkingRepository parkingRepository, CurrencyJsonParsingService currencyJsonParsingService, UserRepository userRepository) {
        this.parkingService = parkingService;
        this.parkingRepository = parkingRepository;
        this.currencyJsonParsingService = currencyJsonParsingService;
        this.userRepository = userRepository;
    }

    //-------------    ADD PARKING VIEW ******START --------------//
    @GetMapping("/add_form")
    public String addParkingForm(Model model, @ModelAttribute("currentUser") User user) {
        model.addAttribute("parkingAddress", new ParkingAddress());
        return "parking/parking_add_form";
    }

    @PostMapping("/save")
    public String saveParking(@ModelAttribute ParkingAddress parkingAddress, @RequestParam ("imageFile") MultipartFile imageFile,
                              @RequestParam("timeFromDATE") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localFromDate,
                              @RequestParam("timeFomHOURS") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime localFromTime,
                              @RequestParam("timeToDATE") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localToDate,
                              @RequestParam("timeToHOURS") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime localToTime) throws IOException {
        parkingService.createParkingPlace(parkingAddress, imageFile);
        return "redirect:/parking/list";
    }
    //-------------    ADD PARKING VIEW *****FINISH --------------//


    //-------------    PARKING VIEW LIST   --------------//
    @GetMapping("/list")
    public String listOfParkings(Model model) {
        List<ParkingAddress> parkingAddresses = parkingService.allParkingPlaces();
        model.addAttribute("parkingAddresses", parkingAddresses);
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



