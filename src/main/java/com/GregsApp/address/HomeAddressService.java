package com.GregsApp.address;

import com.GregsApp.user.User;
import com.GregsApp.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class HomeAddressService {

    private HomeAddressRepository homeAddressRepository;
    private UserRepository userRepository;


    @Autowired
    public HomeAddressService(HomeAddressRepository homeAddressRepository, UserRepository userRepository) {
        this.homeAddressRepository = homeAddressRepository;
        this.userRepository = userRepository;
    }

    public void addAddress(Long userId, HomeAddress homeAddress){
        User userById = userRepository.findOneById(userId);
//        userById.setHomeAddress(homeAddress);
        homeAddress.setUser(userById);
        homeAddressRepository.save(homeAddress);
    }
    public void getHomeAddresses(){
        homeAddressRepository.findAll();
    }
    public HomeAddress getUserHomeAddress(Long userId){
        HomeAddress addresById = homeAddressRepository.findOneById(userId);
        return homeAddressRepository.findOneByUserId(addresById.getId());
    }
}
