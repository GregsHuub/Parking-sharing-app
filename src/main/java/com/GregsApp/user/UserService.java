package com.GregsApp.user;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;
//    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //zweryfikowac todo
    public void createUser(User user){
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
    public void updateUser(User user){
        User userById = getUserById(user.getId());
        userRepository.save(userById);
    }
    public User getUserById(Long id){
        return userRepository.findOneById(id);
    }
    public void deleteUserById(User user){
        userRepository.delete(user);
    }

    public List<User> getList(){
        return userRepository.findAll();
    }

}
