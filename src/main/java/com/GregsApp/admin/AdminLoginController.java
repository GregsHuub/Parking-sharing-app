package com.GregsApp.admin;

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
        model.addAttribute("admin", new Admin());
        return "admin/admin_register";
    }
    @PostMapping("/register_save")
    @ResponseBody
    public String adminSave(@ModelAttribute Admin admin){
        adminService.createAdminProfile(admin);
        return "admin profile ready: " + admin.getEmail() + " " + admin.getUuid();
    }

}
