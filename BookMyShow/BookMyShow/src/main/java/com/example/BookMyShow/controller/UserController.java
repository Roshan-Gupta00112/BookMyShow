package com.example.BookMyShow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("add")
    public ResponseEntity addUser(@RequestBody UserEntryDto userEntryDto){
        userService.addUser(userEntryDto);
        return new ResponseEntity("Added a success User", HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponseDto> gerUser(@PathVariable(value = "id")int id){
        UserResponseDto userResponseDto=userService.getUser(id);
        return new ResponseEntity<>(userResponseDto,HttpStatus.OK);
    }
}