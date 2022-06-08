package ru.acuma.shufflerlib.model.web.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Accessors(chain = true)
@JsonRootName("games")
public class WebGame {

    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private Timestamp date;

    private Integer change;

    private List<WebTeam> teams;

}
