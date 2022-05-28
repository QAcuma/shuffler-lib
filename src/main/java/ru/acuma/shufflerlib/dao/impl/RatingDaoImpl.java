package ru.acuma.shufflerlib.dao.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.acuma.shufflerlib.dao.RatingDao;

@Repository
@RequiredArgsConstructor
public class RatingDaoImpl implements RatingDao {

    private final DSLContext dsl;
}
