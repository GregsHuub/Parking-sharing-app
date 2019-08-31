package com.GregsApp.parking_addresses;

import com.GregsApp.date.DateTimeConfig;
import com.GregsApp.nbpCurrencyApi.CurrencyJsonParsingService;
import com.GregsApp.parkingAvalibility.ParkingAvailabilityService;
import com.GregsApp.user.User;
import com.GregsApp.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/parking")
public class ParkingController {

    private ParkingService parkingService;
    private ParkingRepository parkingRepository;
    private CurrencyJsonParsingService currencyJsonParsingService;
    private UserRepository userRepository;
    private DateTimeConfig dateTimeConfig;
    private ParkingAvailabilityService availabilityService;

    @Autowired
    public ParkingController(ParkingService parkingService, ParkingRepository parkingRepository, CurrencyJsonParsingService currencyJsonParsingService, UserRepository userRepository, DateTimeConfig dateTimeConfig, ParkingAvailabilityService availabilityService) {
        this.parkingService = parkingService;
        this.parkingRepository = parkingRepository;
        this.currencyJsonParsingService = currencyJsonParsingService;
        this.userRepository = userRepository;
        this.dateTimeConfig = dateTimeConfig;
        this.availabilityService = availabilityService;
    }

    //-------------    ADD PARKING VIEW ******START --------------//
    @GetMapping("/add_form")
    public String addParkingForm(Model model, @ModelAttribute("currentUser") User user) {
        model.addAttribute("parkingAddress", new ParkingAddress());
        return "parking_add_form";
    }

    @PostMapping("/save")
    public String saveParking(@ModelAttribute ParkingAddress parkingAddress, @RequestParam ("imageFile") MultipartFile imageFile) throws IOException {
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
    @RequestMapping(value = "/test_param", method = RequestMethod.GET)
    @ResponseBody
    public String foundAddressByStreetPart(@RequestParam("street") String street) {
        return "" + parkingService.allParkingsByPartStreetName(street);
    }

}



