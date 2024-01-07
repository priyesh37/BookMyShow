package com.bookMyshow.Book.My.Show.dto.request;

import com.bookMyshow.Book.My.Show.models.Screen;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddScreenDTO {

    List<Screen> screens;
    int hallId;
}
