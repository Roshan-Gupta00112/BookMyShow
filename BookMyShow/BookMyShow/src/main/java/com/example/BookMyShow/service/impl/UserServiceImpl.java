package com.example.BookMyShow.service.impl;

import com.example.BookMyShow.converter.UserConverter;
import com.example.BookMyShow.dto.entryDto.UserEntryDto;
import com.example.BookMyShow.dto.responseDto.UserResponseDto;
import com.example.BookMyShow.model.User;
import com.example.BookMyShow.repository.UserRepository;
import com.example.BookMyShow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public void addUser(UserEntryDto userDto) {

        User user= UserConverter.dtoToEntity(userDto);
        userRepository.save(user);
    }

    @Override
    public UserResponseDto getUser(int id) {
        User user=userRepository.findById(id).get();
        UserResponseDto userDto=UserConverter.entityToDto(user);
        return userDto;
    }
}