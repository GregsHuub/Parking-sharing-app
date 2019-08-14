//package com.GregsApp.user;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//@RequestMapping("/login")
//public class LoginController {
//
//    private UserRepository userRepository;
//    private UserService userService;
//
//    public LoginController(UserRepository userRepository, UserService userService) {
//        this.userRepository = userRepository;
//        this.userService = userService;
//    }
//
//    @GetMapping("/signUp")
//    public String loginForm(Model model){
//        model.addAttribute("user", new User());
//        return "index";
//    }
//    @PostMapping("/save")
//    @ResponseBody
//    public String saveUser(@ModelAttribute User user){
//        userService.createUser(user);
//        return "udalo sie";
//    }
//    @ModelAttribute
//    public void numberModel(Model model){
//        String str = "tekstowo z modelu";
//        model.addAttribute("number", str);
//    }
//}
