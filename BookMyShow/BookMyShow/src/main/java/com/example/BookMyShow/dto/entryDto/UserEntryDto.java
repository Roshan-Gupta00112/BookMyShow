package com.example.BookMyShow.dto.entryDto;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class UserEntryDto {

    @NonNull
    String name;

    String mobile;
}
