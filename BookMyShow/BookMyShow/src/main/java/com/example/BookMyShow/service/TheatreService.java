package com.example.BookMyShow.service;

import com.example.BookMyShow.dto.entryDto.TheatreEntryDto;
import com.example.BookMyShow.dto.responseDto.TheatreResponseDto;

public interface TheatreService {

    public TheatreResponseDto addTheatre(TheatreEntryDto theatreDto);

    public TheatreResponseDto getTheatre(int id);

}