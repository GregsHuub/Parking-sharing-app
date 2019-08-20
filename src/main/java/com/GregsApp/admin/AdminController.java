package com.GregsApp.admin;

import com.GregsApp.address.HomeAddressService;
import com.GregsApp.user.User;
import com.GregsApp.user.UserService;
import com.GregsApp.users_parking_addresses.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
    private AdminService adminService;

    @Autowired
    public AdminController(UserService userService, HomeAddressService homeAddressService, ParkingService parkingService, AdminService adminService) {
        this.userService = userService;
        this.homeAddressService = homeAddressService;
        this.parkingService = parkingService;
        this.adminService = adminService;
    }

    @GetMapping("/createAccount")
    public String createAccount(Model model){
        model.addAttribute("admin", new Admin());
        return "admin/admin_create_form";
    }
    @PostMapping("/saveAccount")
    @ResponseBody
    public String saveAccount(@ModelAttribute Admin admin){
        adminService.createAdminProfile(admin);
        return "account create properly and added to DataBase " + admin;
    }

    @ModelAttribute
    public void addresList(Model model){
        model.addAttribute("address", homeAddressService.getHomeAddresses());
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


    @GetMapping("/access-denied")
    @ResponseBody
    public String testAdminResposne(){
        return "access-denied";
    }


}
