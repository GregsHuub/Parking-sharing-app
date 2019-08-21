package com.GregsApp.user;

import com.GregsApp.authentication.Role;
import com.GregsApp.authentication.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createUser(UserDto userDto) {
        User user = new User();
        user.setEnabled(true);
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        user.setContactNumber(userDto.getContactNumber());
        user.setEmail(userDto.getEmail());
        user.setCreatedOn(userDto.getCreatedOn());

        Role userRole = roleRepository.findOneByName("ROLE_USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));

        userRepository.save(user);
    }

    public User findUserByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    public void updateUser(User user) {
        User userById = userRepository.findOneById(user.getId());
        userRepository.save(userById);
    }

    public User getUserById(Long id) {
        return userRepository.findOneById(id);
    }

    public void deleteUserById(User userById) {
        userRepository.delete(userById);
    }

    public List<User> getList() {
        return userRepository.findAll();
    }


}
