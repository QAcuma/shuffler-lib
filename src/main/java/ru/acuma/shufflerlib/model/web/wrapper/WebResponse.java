package ru.acuma.shufflerlib.model.web.wrapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class WebResponse<T> extends ResponseEntity<T> {

    public WebResponse(T body) {
        this(body, HttpStatus.OK);
    }

    public WebResponse(T body, HttpStatus status) {
        super(body, status);
    }
}
