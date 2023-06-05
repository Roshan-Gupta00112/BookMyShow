package com.example.BookMyShow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ticket")
public class TicketController {

    @Autowired
    TicketServiceImpl ticketService;

    @PostMapping("/add")
    public TicketResponseDto addTicket(@RequestBody() BookTicketRequestDto bookTicketRequestDto){
        return ticketService.bookTicket(bookTicketRequestDto);
    }

    @GetMapping("get/{id}")
    public TicketResponseDto getTicket(@PathVariable Integer id){
        return  ticketService.getTicket(id);
    }
}