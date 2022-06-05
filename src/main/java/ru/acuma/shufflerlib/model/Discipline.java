package ru.acuma.shufflerlib.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@Getter
@RequiredArgsConstructor
public enum Discipline {

    KICKER("kicker"),
    PING_PONG("pong");

    private final String webName;

    public static Discipline getByWebName(String webName) {
        return Arrays.stream(Discipline.values())
                .filter(discipline -> discipline.getWebName().equals(webName))
                .findFirst()
                .orElseThrow(() -> new EnumConstantNotPresentException(Discipline.class, webName));
    }

}
