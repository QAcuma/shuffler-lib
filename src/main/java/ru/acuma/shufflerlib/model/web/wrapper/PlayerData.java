package ru.acuma.shufflerlib.model.web.wrapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.acuma.shufflerlib.model.web.entity.WebPlayer;
import ru.acuma.shufflerlib.model.web.entity.WebPlayerDetails;

@Getter
@Setter
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayerData extends WebEntity {

    private WebPlayer player;

    private WebPlayerDetails playerDetails;

    public PlayerData(WebPlayer player) {
        this.player = player;
    }

    public PlayerData(WebPlayerDetails playerDetails) {
        this.playerDetails = playerDetails;
    }
}
