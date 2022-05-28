package ru.acuma.shufflerlib.dao.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.acuma.shufflerlib.dao.GameDao;

@Repository
@RequiredArgsConstructor
public class GameDaoImpl implements GameDao {

    private final DSLContext dsl;
}
