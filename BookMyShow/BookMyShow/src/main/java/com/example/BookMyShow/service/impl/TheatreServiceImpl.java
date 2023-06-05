package com.example.BookMyShow.service.impl;

import com.example.BookMyShow.converter.TheatreConverter;
import com.example.BookMyShow.dto.entryDto.TheatreEntryDto;
import com.example.BookMyShow.dto.responseDto.TheatreResponseDto;
import com.example.BookMyShow.enums.SeatType;
import com.example.BookMyShow.model.Theatre;
import com.example.BookMyShow.model.TheatreSeat;
import com.example.BookMyShow.repository.TheatreRepository;
import com.example.BookMyShow.repository.TheatreSeatRepository;
import com.example.BookMyShow.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreServiceImpl implements TheatreService {

    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    TheatreSeatRepository theatreSeatRepository;

    @Override
    public TheatreResponseDto addTheatre(TheatreEntryDto theatreDto) {
        Theatre theatre= TheatreConverter.dtoToEntity(theatreDto);

        List<TheatreSeat> theatreSeatList=createSeats();

        theatre.setTheatreSeats(theatreSeatList);

        theatre.setShows(null);

        for (TheatreSeat theatreSeat : theatreSeatList){
            theatreSeat.setTheatre(theatre);
        }

        //theatre.setType(TheatreType.SINGLE);

        theatre=theatreRepository.save(theatre);

        theatreSeatRepository.saveAll(theatreSeatList);

        TheatreResponseDto theatreResponseDto=TheatreConverter.entityToDto(theatre);

        return theatreResponseDto;
    }

    public List<TheatreSeat> createSeats(){
        List<TheatreSeat> seats= new ArrayList<>();

        seats.add(getTheatreSeat("A1",100,SeatType.SILVER));
        seats.add(getTheatreSeat("A2",100,SeatType.SILVER));
        seats.add(getTheatreSeat("A3",100,SeatType.SILVER));
        seats.add(getTheatreSeat("A4",100,SeatType.SILVER));
        seats.add(getTheatreSeat("A5",100,SeatType.SILVER));

        seats.add(getTheatreSeat("B1",200,SeatType.GOLD));
        seats.add(getTheatreSeat("B2",200,SeatType.GOLD));
        seats.add(getTheatreSeat("B3",200,SeatType.GOLD));
        seats.add(getTheatreSeat("B4",200,SeatType.GOLD));
        seats.add(getTheatreSeat("B5",200,SeatType.GOLD));

        seats.add(getTheatreSeat("C1",300,SeatType.SOFA));
        seats.add(getTheatreSeat("C2",300,SeatType.SOFA));
        seats.add(getTheatreSeat("C3",300,SeatType.SOFA));
        seats.add(getTheatreSeat("C4",300,SeatType.SOFA));
        seats.add(getTheatreSeat("C5",300,SeatType.SOFA));

        return seats;
    }

    public TheatreSeat getTheatreSeat(String seatNo, int rate, SeatType seatType){
        return TheatreSeat.builder().seatNumber(seatNo).rate(rate).seatType(seatType).build();
    }

    @Override
    public TheatreResponseDto getTheatre(int id) {
        Theatre theatre=theatreRepository.findById(id).get();
        TheatreResponseDto theatreDto= TheatreConverter.entityToDto(theatre);
        return theatreDto;
    }
}