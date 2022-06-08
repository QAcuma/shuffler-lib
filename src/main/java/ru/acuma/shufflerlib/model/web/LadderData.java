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
public class LadderData extends WebMessage {

    private final List<WebPlayer> players;

    public LadderData(List<WebPlayer> players) {
        this(players, null);
    }

    public LadderData(List<WebPlayer> players, String message) {
        super(message);
        this.players = players;
    }

}
