package com.example.BookMyShow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
