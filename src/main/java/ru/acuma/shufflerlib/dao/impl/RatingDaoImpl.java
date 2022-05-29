package ru.acuma.shufflerlib.dao.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.acuma.k.shuffler.tables.pojos.Rating;
import ru.acuma.k.shuffler.tables.records.PlayerRecord;
import ru.acuma.k.shuffler.tables.records.RatingRecord;
import ru.acuma.shufflerlib.dao.RatingDao;
import ru.acuma.shufflerlib.model.Discipline;

import static ru.acuma.k.shuffler.tables.Player.PLAYER;
import static ru.acuma.k.shuffler.tables.Rating.RATING;

@Repository
@RequiredArgsConstructor
public class RatingDaoImpl implements RatingDao {

    private final DSLContext dsl;

    @Override
    public Rating getRating(Long playerId, Discipline discipline) {
        return null;
    }

    @Override
    public long save(Rating rating) {
        RatingRecord record = dsl.newRecord(RATING, rating);
        record.store();
        return record.getId();
    }
}
