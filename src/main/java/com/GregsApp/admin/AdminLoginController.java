package com.GregsApp.admin;

import com.GregsApp.user.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminLoginController {

    private AdminService adminService;

    @Autowired
    public AdminLoginController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/login")
    public String adminLoginForm(){
        return "admin/admin_login";
    }

    @GetMapping("/register")
    public String adminRegisterForm(Model model){
        model.addAttribute("admin", new UserDto());
        return "admin/admin_register";
    }
    @PostMapping("/register_save")
    public String adminSave(@ModelAttribute UserDto adminProfile){
        adminService.createAdminAccount(adminProfile);
        return "redirect:/admin/main_panel";
    }

}
