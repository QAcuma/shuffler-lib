package ru.acuma.shufflerlib.model.web.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WebPlayerDetails extends WebPlayer {

    private Integer winCount;

    private Integer loseCount;

    public WebPlayerDetails(Long id, String name, String avatar, Integer score, Integer winCount, Integer loseCount) {
        super(id, name, avatar, score);
        this.winCount = winCount;
        this.loseCount = loseCount;
    }
}
