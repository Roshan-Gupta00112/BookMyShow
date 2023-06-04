package com.example.BookMyShow.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Table(name = "theatres")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Theatre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "city",nullable = false)
    private String city;

    TheatreType type;

    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Show> shows;

    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TheatreSeat> theatreSeats=new ArrayList<>();
}
