package ru.acuma.shufflerlib.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class StatisticResult {

    private Long id;

    private String firstName;

    private Integer rating;


}
