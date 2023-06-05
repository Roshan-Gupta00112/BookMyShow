package com.example.BookMyShow.service.impl;


import com.example.BookMyShow.converter.MovieConverter;
import com.example.BookMyShow.dto.entryDto.MovieEntryDto;
import com.example.BookMyShow.dto.responseDto.MovieNameAndIdObject;
import com.example.BookMyShow.dto.responseDto.MovieResponseDto;
import com.example.BookMyShow.model.Movie;
import com.example.BookMyShow.repository.MovieRepository;
import com.example.BookMyShow.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public MovieResponseDto addMovie(MovieEntryDto movieDto) {

        MovieResponseDto movieResponseDto=null;

        if(movieRepository.existsByName(movieDto.getName())){
            movieResponseDto.setName("This Movie Is Already Existing");
            return movieResponseDto;
        }

        log.info("Reached addMovie function");

        Movie movie= MovieConverter.dtoToEntity(movieDto);
        movie= movieRepository.save(movie);

        movieResponseDto= MovieConverter.entityToDto(movie);

        return movieResponseDto;
    }

    public  MovieResponseDto getMovie(int id){
        Movie movie=movieRepository.findById(id).get();
        MovieResponseDto movieResponseDto=MovieConverter.entityToDto(movie);
        return  movieResponseDto;
    }

    @Override
    public MovieNameAndIdObject getNameAndId(int id) {
        Movie movie=movieRepository.findById(id).get();
        MovieNameAndIdObject obj=MovieConverter.entityToObj(movie);
        return obj;
    }
}