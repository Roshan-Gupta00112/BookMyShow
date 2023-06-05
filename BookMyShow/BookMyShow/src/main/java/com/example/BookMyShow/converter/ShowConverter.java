package com.example.BookMyShow.converter;

import com.example.BookMyShow.model.Show;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ShowConverter {

    public static Show dtoToEntity(ShowEntryDto showDto){

        return Show.builder().
                showDate(showDto.getShowDate()).
                showTime(showDto.getShowTime()).
                build();
    }
    public static ShowResponseDto entityToDto(Show show,ShowEntryDto showEntryDto){
        return ShowResponseDto.builder().
                id(show.getId()).
                showDate(show.getShowDate()).
                showTime(show.getShowTime()).
                movieResponseDto(showEntryDto.getMovieResponseDto()).
                theatreResponseDto(showEntryDto.getTheatreResponseDto()).
                build();
    }
    public static ShowResponseDto entityToDto(Show show){
        return ShowResponseDto.builder().
                id(show.getId()).
                showDate(show.getShowDate()).
                showTime(show.getShowTime()).
                build();
    }
}