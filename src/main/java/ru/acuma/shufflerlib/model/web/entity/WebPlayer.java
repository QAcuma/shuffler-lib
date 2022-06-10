package ru.acuma.shufflerlib.model.web.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import ru.acuma.shufflerlib.model.web.wrapper.WebEntity;

@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WebPlayer {

    private Long id;

    private String name;

    private Integer score;

}