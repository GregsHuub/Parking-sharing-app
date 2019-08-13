package com.GregsApp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;
    private UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }
    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("user", new User());
        return "userAddThym";
    }

    @PostMapping("/save")
    @ResponseBody
    public String saveForm(@ModelAttribute User user){
        userService.createUser(user);
        return "Job done - Used added to DataBase(DB)";
    }
    @GetMapping("/list")
    public String getListOfUsers(Model model){
        model.addAttribute("listOfUsers", userService.getList());
        return "userAddThym";
    }
    @GetMapping("/fb")
    public String fbtest(){
        return "test";
    }
}
