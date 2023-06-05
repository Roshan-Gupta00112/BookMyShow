package com.example.BookMyShow.converter;

import com.example.BookMyShow.model.Movie;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieConverter {

    public static Movie dtoToEntity(MovieEntryDto movieDto){
        return Movie.builder().
                name(movieDto.getName()).
                releaseDate(movieDto.getReleaseDate()).
                build();
    }

    public static MovieResponseDto entityToDto(Movie movie){
        return  MovieResponseDto.builder().id(movie.getId()).releaseDate(movie.getReleaseDate()).name(movie.getName()).build();
    }
    public static MovieNameAndIdObject entityToObj(Movie movie){
        return MovieNameAndIdObject.builder().
                id(movie.getId()).
                name(movie.getName()).
                build();
    }
}