package com.example.BookMyShow.converter;

import com.example.BookMyShow.dto.responseDto.TicketResponseDto;
import com.example.BookMyShow.model.Ticket;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TicketConverter {

    public static TicketResponseDto entityToDto(Ticket ticket){
        return TicketResponseDto.builder().id(ticket.getId()).amount(ticket.getAmount()).allottedSeats(ticket.getAllottedSeat()).build();
    }
}