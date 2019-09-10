package com.GregsApp.admin;

import com.GregsApp.address.HomeAddressService;
import com.GregsApp.user.User;
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
    public void addresList(Model model) {
        model.addAttribute("address", homeAddressService.getHomeAddresses());
    }

    @GetMapping("/panel")
    public String adminMainPage(@ModelAttribute("currentUser") User user) {

        return "admin/main_panel";
    }
    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUserCascade(id);
        return "redirect:/admin/usersList";
    }

    // START ---------    USER STUFF
    @GetMapping("/usersList")
    public String usersList(Model model) {
        model.addAttribute("users", userService.getList());
        return "admin/usersList";
    }

    // FINISH ---------    USER STUFF

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
