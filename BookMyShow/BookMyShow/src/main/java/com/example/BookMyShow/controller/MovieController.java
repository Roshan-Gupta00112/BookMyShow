package com.example.BookMyShow.controller;

import com.example.BookMyShow.dto.entryDto.MovieEntryDto;
import com.example.BookMyShow.dto.responseDto.MovieResponseDto;
import com.example.BookMyShow.service.impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movie")
public class MovieController {
    @Autowired
    MovieServiceImpl movieService;

    @PostMapping("/add")
    public MovieResponseDto addShow(@RequestBody() MovieEntryDto movieEntryDto){
        return movieService.addMovie(movieEntryDto);
    }

    @GetMapping("get/{id}")
    public MovieResponseDto getShow(@PathVariable Integer id){
        return movieService.getMovie(id);
    }
}
