package com.example.BookMyShow.controller;

import com.example.BookMyShow.dto.entryDto.UserEntryDto;
import com.example.BookMyShow.dto.responseDto.UserResponseDto;
import com.example.BookMyShow.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserServiceImpl userService;

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody UserEntryDto userEntryDto){

        userService.addUser(userEntryDto);

        return new ResponseEntity("Added a success User", HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable(value = "id")int id){

        UserResponseDto userResponseDto = userService.getUser(id);
        return new ResponseEntity<>(userResponseDto,HttpStatus.OK);
    }

}