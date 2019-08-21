package com.GregsApp.admin;

import com.GregsApp.authentication.Role;
import com.GregsApp.authentication.RoleRepository;
import com.GregsApp.user.User;
import com.GregsApp.user.UserDto;
import com.GregsApp.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class AdminService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public AdminService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public void createAdminAccount(UserDto userDto) {
        User user = new User();
        user.setEnabled(true); // TODO: 21.08.2019 tutaj można by enablowac za pomoca maila
        user.setLastName(userDto.getLastName());
        user.setFirstName(userDto.getFirstName());
        user.setContactNumber(userDto.getContactNumber());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setEmail(userDto.getEmail());
        user.setCreatedOn(userDto.getCreatedOn());

        Role adminRole = roleRepository.findOneByName("ROLE_ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(adminRole)));

        userRepository.save(user);
    }

    public User changeAdminRoleToUser(User user) {
        User userById = userRepository.findOneById(user.getId());
        Role userRole = roleRepository.findOneByName("ROLE_USER");
        userById.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        return userRepository.save(userById);
    }

    public List<User> getListOfAdmins() {
        List<User> allUsers = userRepository.findAll();
        List<User> temp;
        Role adminRole = roleRepository.findOneByName("ROLE_ADMIN");

        temp = allUsers.stream().
                filter(s -> s.getRoles().
                        contains(adminRole)).
                collect(Collectors.toList());
//        for (int i = 0; i < allUsers.size(); i++) {
//            User userFor = allUsers.get(i);
//            for(int j = 0; j < userFor.getRoles().size(); i++){
//                Set<Role> roles = userFor.getRoles();
//                if(roles.contains(adminRole)){
//                 temp.add(userFor);
//                }
//            }
//        }
        return temp;
    }

}
