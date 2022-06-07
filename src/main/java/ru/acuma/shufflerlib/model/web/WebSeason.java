package ru.acuma.shufflerlib.model.web;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class WebSeason {

    private Long id;

    private String name;

}
