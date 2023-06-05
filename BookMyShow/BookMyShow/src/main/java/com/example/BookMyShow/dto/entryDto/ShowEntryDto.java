package com.example.BookMyShow.dto.entryDto;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@Builder
public class ShowEntryDto {

    @NonNull
    LocalDate showDate;

    @NonNull
    LocalTime showTime;

    @NonNull
    MovieResponseDto movieResponseDto;

    @NonNull
    TheatreResponseDto theatreResponseDto;
}
