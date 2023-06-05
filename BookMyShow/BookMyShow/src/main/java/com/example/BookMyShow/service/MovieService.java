package com.example.BookMyShow.service;

import com.example.BookMyShow.dto.entryDto.MovieEntryDto;
import com.example.BookMyShow.dto.responseDto.MovieNameAndIdObject;
import com.example.BookMyShow.dto.responseDto.MovieResponseDto;

public interface MovieService {

    //add
    public MovieResponseDto addMovie(MovieEntryDto movieDto);

    public MovieNameAndIdObject getNameAndId(int id);

    //get
    public MovieResponseDto getMovie(int id);
}