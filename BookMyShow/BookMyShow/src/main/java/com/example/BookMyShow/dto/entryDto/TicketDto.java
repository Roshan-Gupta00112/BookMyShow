package com.example.BookMyShow.dto.entryDto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class TicketDto {
    int id;
    double amount;
    Set<String> allottedSeats;

    ShowResponseDto showDto;
    UserResponseDto userDto;
}