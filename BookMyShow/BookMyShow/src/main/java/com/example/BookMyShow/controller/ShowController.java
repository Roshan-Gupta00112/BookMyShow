package com.example.BookMyShow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("show")
public class ShowController {
    @Autowired
    ShowServiceImpl showService;

    @PostMapping("/add")
    public ShowResponseDto addShow(@RequestBody()ShowEntryDto showEntryDto){
        return showService.addShow(showEntryDto);
    }

    @GetMapping("get/{id}")
    public ShowResponseDto getShow(@PathVariable Integer id){
        return showService.getShow(id);
    }
}
