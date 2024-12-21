package com.example.java.controller;

import com.example.java.Enum.Operator;
import com.example.java.Enum.UserFilter;
import com.example.java.dto.UserCreatedRequest;
import com.example.java.dto.UserCreatedResponse;
import com.example.java.dto.UserFilterResponse;
import com.example.java.model.User;
import com.example.java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

//    need some validation for some of the field
    @PostMapping("/addStudent")
    public UserCreatedResponse addStudent(@RequestBody @Validated UserCreatedRequest request){
        return userService.addStudent(request);

    }

    @GetMapping("/filter")
    public List<User> filteredByPhone(@RequestParam("filterBy") UserFilter filterBy,
                                      @RequestParam("operator") Operator operator,
                                      @RequestParam("value") String value){
// UserFilter.valueOf(filterBy) --> for typecasting
        return userService.filter(filterBy, operator, value);

    }


}

//user created
//updatied
//search
//delete