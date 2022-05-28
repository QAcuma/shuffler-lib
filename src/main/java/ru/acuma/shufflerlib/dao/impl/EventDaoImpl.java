package ru.acuma.shufflerlib.dao.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.acuma.shufflerlib.dao.EventDao;

@Repository
@RequiredArgsConstructor
public class EventDaoImpl implements EventDao {

    private final DSLContext dsl;
}
