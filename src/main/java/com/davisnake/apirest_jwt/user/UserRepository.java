package com.davisnake.apirest_jwt.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByUserName(String userName);

    @Modifying()
    @Query("update User u set u.firstName=:firstName, u.lastName=:lastName, u.country=:country where u.id = :id")
    Integer updateUser(@Param(value = "id") Integer id,   @Param(value = "firstName") String firstName, @Param(value = "lastName") String lastName , @Param(value = "country") String country);

}
