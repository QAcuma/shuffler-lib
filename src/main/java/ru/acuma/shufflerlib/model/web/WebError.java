package ru.acuma.shufflerlib.model.web;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class WebError {

    public WebError(String title, String cause) {
        this.title = title;
        this.cause = cause;
    }

    private final String title;
    private final String cause;

}
