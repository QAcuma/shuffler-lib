package ru.acuma.shufflerlib.dao.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.acuma.k.shuffler.tables.pojos.Rating;
import ru.acuma.shufflerlib.dao.RatingDao;
import ru.acuma.shufflerlib.model.Discipline;

@Repository
@RequiredArgsConstructor
public class RatingDaoImpl implements RatingDao {

    private final DSLContext dsl;

    @Override
    public Rating getRating(Long playerId, Discipline discipline) {
        return null;
    }

    @Override
    public void save(Rating rating) {

    }
}
