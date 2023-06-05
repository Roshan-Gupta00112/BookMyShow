package com.example.BookMyShow.dto.responseDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TicketResponseDto {
    int id;
    double amount;
    String allottedSeats;
}