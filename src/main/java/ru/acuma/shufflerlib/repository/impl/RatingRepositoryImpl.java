package ru.acuma.shufflerlib.repository.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.acuma.shuffler.tables.daos.RatingDao;
import ru.acuma.shuffler.tables.pojos.Rating;
import ru.acuma.shuffler.tables.records.RatingRecord;
import ru.acuma.shufflerlib.repository.RatingRepository;
import ru.acuma.shufflerlib.model.Discipline;

import static ru.acuma.shuffler.tables.Rating.RATING;

@Repository
@RequiredArgsConstructor
public class RatingRepositoryImpl implements RatingRepository {

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
        RatingDao ratingDao = new RatingDao(dsl.configuration());
        ratingDao.update(rating);
    }
}
