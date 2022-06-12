package ru.acuma.shufflerlib.model.web.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.sql.Timestamp;
import java.time.OffsetDateTime;

@Getter
@Setter
@Accessors(chain = true)
public class WebCoordinate {

    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private Timestamp date;

    private Integer score;

    public WebCoordinate(OffsetDateTime date, Integer score) {
        this.date = Timestamp.from(date.toInstant());
        this.score = score;
    }
}
