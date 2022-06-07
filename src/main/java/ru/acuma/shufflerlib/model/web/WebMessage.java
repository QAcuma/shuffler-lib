package ru.acuma.shufflerlib.model.web;

import lombok.Getter;

@Getter
public class WebMessage {

    public WebMessage(String text) {
        this.text = text;
    }

    private final String text;

}
