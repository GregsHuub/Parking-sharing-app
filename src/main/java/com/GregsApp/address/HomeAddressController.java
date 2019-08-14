package com.GregsApp.address;

import com.GregsApp.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/address")
public class HomeAddressController {

    private HomeAddressService homeAddressService;

    @Autowired
    public HomeAddressController(HomeAddressService homeAddressService) {
        this.homeAddressService = homeAddressService;
    }

    @GetMapping("/addForm")
    public String addAddress(Model model){
        model.addAttribute("address", new HomeAddress());
        return "add_address";
    }
// todo ID USERA SPRAWDZIC
    @PostMapping("/save")
    @ResponseBody
    public String saveAddress(@ModelAttribute HomeAddress homeAddress, User user){
        homeAddressService.addAddress(user.getId(), homeAddress);
        return "addres added :" + homeAddress.toString() + " " + user.toString();
    }
}
