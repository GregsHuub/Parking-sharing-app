package com.GregsApp.users_parking_addresses;

import com.GregsApp.nbpCurrencyApi.CurrencyJsonParsingService;
import com.GregsApp.user.User;
import com.GregsApp.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

//    testowa
    @GetMapping("/add")
    public String addParking(Model model){
        model.addAttribute("parkingAddress", new ParkingAddress());
        return "parking/parking_add_form";
    }
//    testowa
    @GetMapping("/add_form")
    public String addParkingForm( Model model, @ModelAttribute("currentUser") User user){
        model.addAttribute("parkingAddress", new ParkingAddress());

        return "parking/parking_add_form_real";
    }
    @PostMapping("/save")
    public String saveParking(@ModelAttribute ParkingAddress parkingAddress){
        parkingService.createParkingPlace(parkingAddress);
        return "redirect:/list";
    }

    @GetMapping("/list")
    public String listOfParkings(Model model){
        List<ParkingAddress> parkingAddresses = parkingService.allParkingPlaces();
        model.addAttribute("parkingAddresses", parkingAddresses);
        return "parking/parkingList";
    }

    // pobieranie parametru street do testu //

    @RequestMapping(value="/test_param", method = RequestMethod.GET)
    @ResponseBody
    public String foundAddressByStreetPart(@RequestParam("street") String street){
        List<ParkingAddress> parkings = parkingService.allParkingsByPartStreetName(street);
        return "<h1>Parkings:</h1><br>" + parkings;
    }





}
