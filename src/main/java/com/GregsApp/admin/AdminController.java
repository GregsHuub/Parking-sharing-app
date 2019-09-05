package com.GregsApp.admin;

import com.GregsApp.address.HomeAddressService;
import com.GregsApp.user.UserDto;
import com.GregsApp.user.UserService;
import com.GregsApp.parking_addresses.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@Secured("ROLE_ADMIN")
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;
    private HomeAddressService homeAddressService;
    private ParkingService parkingService;

    @Autowired
    public AdminController(UserService userService, HomeAddressService homeAddressService, ParkingService parkingService) {
        this.userService = userService;
        this.homeAddressService = homeAddressService;
        this.parkingService = parkingService;

    }

    @ModelAttribute
    public void addresList(Model model){
        model.addAttribute("address", homeAddressService.getHomeAddresses());
    }

    @GetMapping("/main_panel")
        public String adminMainPage(){

        return "admin/index";
    }

    @GetMapping("/usersList")
    public String usersList(Model model) {
        model.addAttribute("users", userService.getList());
        return "admin/admin_users_list";
    }

    @GetMapping("/parkingList")
    public String parkingList(Model model) {
        model.addAttribute("parking", parkingService.allParkingPlaces());
        return "admin/admin_parkings_list";
    }

    @GetMapping("/access-denied")
    @ResponseBody
    public String testAdminResposne() {
        return "access-denied";
    }


}
