package ru.acuma.shufflerlib.model.web.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Accessors(chain = true)
public class WebGraph {

    private Long playerId;

    private List<WebCoordinate> coordinates;

}
