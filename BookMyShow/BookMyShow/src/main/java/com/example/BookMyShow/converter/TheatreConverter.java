package com.example.BookMyShow.converter;

import com.example.BookMyShow.dto.entryDto.TheatreEntryDto;
import com.example.BookMyShow.dto.responseDto.TheatreResponseDto;
import com.example.BookMyShow.model.Theatre;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TheatreConverter {

    public static Theatre dtoToEntity(TheatreEntryDto theatreDto){
        return Theatre.builder().
                name(theatreDto.getName()).
                address(theatreDto.getAddress()).
                city(theatreDto.getCity()).
                type(theatreDto.getType()).
                build();
    }
    public static TheatreResponseDto entityToDto(Theatre theatre){
        return TheatreResponseDto.builder().
                id(theatre.getId()).
                name(theatre.getName()).
                address(theatre.getAddress()).
                city(theatre.getCity()).
                type(theatre.getType()).
                build();
    }
}