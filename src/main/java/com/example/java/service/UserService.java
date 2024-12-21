package com.example.java.service;

import com.example.java.Enum.Operator;
import com.example.java.Enum.UserFilter;
import com.example.java.Enum.UserType;
import com.example.java.dto.UserCreatedRequest;
import com.example.java.dto.UserCreatedResponse;
//import com.example.java.dto.UserFilterResponse;
import com.example.java.model.User;
import com.example.java.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserCreatedResponse addStudent(UserCreatedRequest request) {
        User user = request.toUser();
        user.setUserType(UserType.STUDENT);
        User userFromDb = userRepository.save(user);
        return UserCreatedResponse.builder().
                userAddress(userFromDb.getAddress()).
                userEmail(userFromDb.getEmail()).
                userName(userFromDb.getName()).
                userPhone(userFromDb.getPhoneNo()).build();
    }

    public List<User> filter(UserFilter filterBy, Operator operator, String value) {
        switch (filterBy){
            case NAME :
                switch (operator){
                    case EQUALS :
                        return userRepository.findByName(value);

                    case LIKE:
                        return userRepository.findByNameLike("%" + value + "%");
                }
        }
        return new ArrayList<>();
    }
}
