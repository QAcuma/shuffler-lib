package ru.acuma.shufflerlib.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class Filter {

    private Discipline discipline;
    private String chatName;
    private Long chatId;
    private Long playerId;
    private Long gameId;
    private Long seasonId;

}
