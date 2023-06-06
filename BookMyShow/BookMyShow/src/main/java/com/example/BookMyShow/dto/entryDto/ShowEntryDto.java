package com.example.BookMyShow.dto.entryDto;

import com.example.BookMyShow.dto.responseDto.MovieResponseDto;
import com.example.BookMyShow.dto.responseDto.TheatreResponseDto;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalTime;

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
