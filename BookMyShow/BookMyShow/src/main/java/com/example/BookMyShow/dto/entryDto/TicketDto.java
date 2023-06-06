package com.example.BookMyShow.dto.entryDto;

import com.example.BookMyShow.dto.responseDto.ShowResponseDto;
import com.example.BookMyShow.dto.responseDto.UserResponseDto;
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