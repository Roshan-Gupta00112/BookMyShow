package com.example.BookMyShow.service.impl;

import com.example.BookMyShow.converter.ShowConverter;
import com.example.BookMyShow.dto.entryDto.ShowEntryDto;
import com.example.BookMyShow.dto.responseDto.ShowResponseDto;
import com.example.BookMyShow.model.*;
import com.example.BookMyShow.repository.MovieRepository;
import com.example.BookMyShow.repository.ShowRepository;
import com.example.BookMyShow.repository.ShowSeatsRepository;
import com.example.BookMyShow.repository.TheatreRepository;
import com.example.BookMyShow.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    ShowRepository showRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    ShowSeatsRepository showSeatsRepository;

    @Override
    public ShowResponseDto addShow(ShowEntryDto showDto) {
        Show show= ShowConverter.dtoToEntity(showDto);

        Movie movie=movieRepository.findById(showDto.getMovieResponseDto().getId()).get();
        show.setMovies(movie);

        Theatre theatre=theatreRepository.findById(showDto.getTheatreResponseDto().getId()).get();
        show.setTheatre(theatre);

        show=showRepository.save(show);
        List<ShowSeats> showSeats=createShowSeats(theatre.getTheatreSeats(),show);
        showSeatsRepository.saveAll(showSeats);

        //show.setShowSeats(showSeats);

        ShowResponseDto showResponseDto=ShowConverter.entityToDto(show,showDto);
        return showResponseDto;
    }

    public List<ShowSeats> createShowSeats(List<TheatreSeat> theatreSeat, Show show){
        List<ShowSeats> showSeats=new ArrayList<>();

        for(TheatreSeat seat : theatreSeat){
            ShowSeats showSeat = ShowSeats.builder().
                    seatNumber(seat.getSeatNumber()).
                    rate(seat.getRate()).
                    seatType(seat.getSeatType()).
                    build();

            showSeats.add(showSeat);
        }

        for(ShowSeats seats : showSeats){
            seats.setShow(show);
        }
        show.setShowSeats(showSeats);
        return showSeats;
    }

    @Override
    public ShowResponseDto getShow(int id) {
        Show show= showRepository.findById(id).get();
        return ShowConverter.entityToDto(show);
    }
}