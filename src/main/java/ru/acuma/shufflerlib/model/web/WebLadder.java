package ru.acuma.shufflerlib.model.web;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WebLadder {

    public WebLadder(List<WebPlayer> players) {
        this.players = players;
    }

    List<WebPlayer> players;

}
