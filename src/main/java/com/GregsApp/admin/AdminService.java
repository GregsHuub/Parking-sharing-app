package com.GregsApp.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private AdminRepository adminRepository;
    private PasswordEncoder passwordEncoder;


    @Autowired
    public AdminService(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createAdminProfile(Admin admin){
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        adminRepository.save(admin);
    }
    public void updateAdminProfile(Admin admin){
        adminRepository.findOneById(admin.getId());
        adminRepository.save(admin);
    }
    public void deleteAdminProfile(Admin admin){
        adminRepository.delete(admin);
    }
    public void deleteAdminProfileById(Admin adminId){
        Admin adminById = adminRepository.findOneById(adminId.getId());
        adminRepository.delete(adminById);
    }
    public List<Admin> getListOfAdmins(){
        return adminRepository.findAll();
    }


}
