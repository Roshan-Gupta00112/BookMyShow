package com.example.BookMyShow.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Table(name = "show_seats")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShowSeats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "rate",nullable = false)
    int rate;

    @Column(name = "seat_number",nullable = false)
    String seatNumber;

    @Column(name = "booked",columnDefinition = "bit(1) default 0",nullable = false)
    boolean booked;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "booked_at")
    Date bookedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "seat_type",nullable = false)
    SeatType seatType;

    @ManyToOne
    @JsonIgnore
    Ticket ticket;

    @ManyToOne
    @JsonIgnore
    Show show;
}
