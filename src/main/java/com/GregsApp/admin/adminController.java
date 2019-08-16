package com.GregsApp.admin;

import com.GregsApp.address.HomeAddressService;
import com.GregsApp.user.UserService;
import com.GregsApp.users_parking_addresses.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class adminController {

    private UserService userService;
    private HomeAddressService homeAddressService;
    private ParkingService parkingService;

    @Autowired
    public adminController(UserService userService, HomeAddressService homeAddressService, ParkingService parkingService) {
        this.userService = userService;
        this.homeAddressService = homeAddressService;
        this.parkingService = parkingService;
    }

    @GetMapping("/usersList")
    public String usersList(Model model){
        model.addAttribute("users", userService.getList());
        return "admin/admin_users_list";
    }
    @GetMapping("/parkingList")
    public String parkingList(Model model){
        model.addAttribute("parking", parkingService.allParkingPlaces());
        return "admin/admin_parkings_list";
    }


}
