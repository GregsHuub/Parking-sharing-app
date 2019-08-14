package com.GregsApp.address;

import com.GregsApp.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeAddressRepository extends JpaRepository<HomeAddress, Long> {

    HomeAddress findOneById(Long id);
    HomeAddress findOneByUserId(Long userId);

}
