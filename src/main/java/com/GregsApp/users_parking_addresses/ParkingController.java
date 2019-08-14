package com.GregsApp.users_parking_addresses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/parking")
public class ParkingController {

    private ParkingService parkingService;
    private ParkingRepository parkingRepository;

    @Autowired
    public ParkingController(ParkingService parkingService, ParkingRepository parkingRepository) {
        this.parkingService = parkingService;
        this.parkingRepository = parkingRepository;
    }

    @GetMapping("/add")
    public String addParking(Model model){
        model.addAttribute("parkingAddress", new ParkingAddress());
        return "parking/parking_add_form";
    }
    @PostMapping("/save")
    public String saveParking(@ModelAttribute ParkingAddress parkingAddress){
        parkingService.createParkingPlace(parkingAddress);
        return "redirect:/parking/list";
    }

    @GetMapping("/list")
    public String listOfParkings(Model model){
        List<ParkingAddress> parkingAddresses = parkingService.allParkingPlaces();
        model.addAttribute("parkingAddresses", parkingAddresses);
        return "parking/parkingList";
    }

}
