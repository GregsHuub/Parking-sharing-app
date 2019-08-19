package com.GregsApp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/user/")
public class UserController {

    private UserService userService;
    private UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }
    //-----------------------    LOGIN FORM -------------------------
    @GetMapping("/login")
    public String createUserForm(Model model){
        model.addAttribute("user", new User());
        return "originalLoginForm";
    }

    @PostMapping("/save")
    @ResponseBody
    public String save(@ModelAttribute User user){
        userService.createUser(user);
        return "Job done - Used added to DataBase(DB)";
    }
//-----------------------    LOGIN FORM -------------------------
    @GetMapping("/list")
    public String getListOfUsers(Model model){
        model.addAttribute("listOfUsers", userService.getList());
        return "userList";
    }
    @GetMapping("/register")
    public String registerForm(Model model){
        model.addAttribute("user", new User());
        return "register";
    }


}
