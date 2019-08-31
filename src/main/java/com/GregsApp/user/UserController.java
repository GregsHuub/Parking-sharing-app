package com.GregsApp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    private UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/list")
    public String getListOfUsers(Model model) {
        model.addAttribute("listOfUsers", userService.getList());
        return "user/userList";
    }

    // ----------------- LOGIN ------------------
    @GetMapping("/login")
    public String loginForm() {
        ;
        return "user/login";
    }


    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "user/register";
    }

    @PostMapping("/signUp/save")
    public String signUpSave(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/register";
        }
        userService.createUser(userDto);
        return "redirect:/";
    }
    // ----------------- LOGIN ------------------


}
