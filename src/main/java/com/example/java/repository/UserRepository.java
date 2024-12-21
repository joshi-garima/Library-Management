package com.example.java.repository;

import com.example.java.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    // search via name
//    search like name

//    3 ways to write the query

    List<User> findByName(String name);
    List<User> findByNameLike(String name);


//    Writing the query
    @Query(value = "select u from User u where name=: name", nativeQuery = false)
    List<User> retrieveUserName(String name);

//    3 way

    @Query(value = "select u from user u where name=: name", nativeQuery = true)
    List<User> retrieveUserNameNative(String name);




}
