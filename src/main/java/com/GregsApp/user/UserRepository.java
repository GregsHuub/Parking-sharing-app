package com.GregsApp.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findOneById(Long id);

    User findOneByEmail(String email);

    User findByEmail(String email);

    User findOneByUuid(String uuid);

    User findOneByFirstName(String firstName);

    User findOneByLastName(String lastName);


}
