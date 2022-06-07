package ru.acuma.shufflerlib.model.web;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Accessors(chain = true)
public class WebGame {

    private Long id;

    private LocalDateTime date;

    private Integer change;

    private List<WebTeam> teams;

}
