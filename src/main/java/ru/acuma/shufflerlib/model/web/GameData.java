package ru.acuma.shufflerlib.model.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GameData extends WebMessage {

    private final List<WebGame> games;

    public GameData(List<WebGame> games) {
        this(games, null);
    }

    public GameData(List<WebGame> games, String message) {
        super(message);
        this.games = games;
    }
}
