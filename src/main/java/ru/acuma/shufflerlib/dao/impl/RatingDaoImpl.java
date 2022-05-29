package ru.acuma.shufflerlib.dao.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.acuma.k.shuffler.tables.pojos.Rating;
import ru.acuma.k.shuffler.tables.records.RatingRecord;
import ru.acuma.shufflerlib.dao.RatingDao;
import ru.acuma.shufflerlib.model.Discipline;

import static ru.acuma.k.shuffler.tables.Rating.RATING;

@Repository
@RequiredArgsConstructor
public class RatingDaoImpl implements RatingDao {

    private final DSLContext dsl;

    @Override
    public Rating getRating(Long playerId, Discipline discipline) {
        return dsl.select()
                .from(RATING)
                .where(RATING.PLAYER_ID.eq(playerId))
                .and(RATING.DISCIPLINE.eq(discipline.name()))
                .fetchOneInto(Rating.class);
    }

    @Override
    public long save(Rating rating) {
        RatingRecord record = dsl.newRecord(RATING, rating);
        record.store();
        return record.getId();
    }

    @Override
    public void update(Rating rating) {
        dsl.update(RATING)
                .set(RATING.RATING_, rating.getRating())
                .where(RATING.ID.eq(rating.getId()))
                .execute();
    }
}
