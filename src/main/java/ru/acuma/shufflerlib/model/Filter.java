package ru.acuma.shufflerlib.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class Filter {

    private long chatId;
    private long playerId;
    private long gameId;
    private long seasonId;
    private Discipline discipline;

}
