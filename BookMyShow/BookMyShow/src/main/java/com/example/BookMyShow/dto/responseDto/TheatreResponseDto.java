package com.example.BookMyShow.dto.responseDto;

import com.example.BookMyShow.enums.TheatreType;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TheatreResponseDto {

    private int id;
    private String name;
    private String city;
    private String address;
    private TheatreType type;

}
