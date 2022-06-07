package ru.acuma.shufflerlib.model.web;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class WebGameInfo {

    private Long gameId;

    private WebPlayer webPlayer;

    private Integer change;






}
