package com.GregsApp.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findOneById(Long id);
    User findOneByEmail(String email);
    User findOneByUuid(String uuid);
    User findOneByFirstName(String firstName);
    User findOneByLastName(String lastName);



}
