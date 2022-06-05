package ru.acuma.shufflerlib.repository.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.acuma.shuffler.tables.daos.RatingDao;
import ru.acuma.shuffler.tables.pojos.Rating;
import ru.acuma.shufflerlib.model.Filter;
import ru.acuma.shufflerlib.repository.RatingRepository;

import javax.annotation.PostConstruct;

import static ru.acuma.shuffler.tables.Rating.RATING;

@Repository
@RequiredArgsConstructor
public class RatingRepositoryImpl implements RatingRepository {

    private final DSLContext dsl;

    private RatingDao ratingDao;

    @PostConstruct
    void initGameDao() {
        ratingDao = new RatingDao(dsl.configuration());
    }

    @Override
    public Rating getRatingByPlayerIdAndDisciplineAndSeasonId(Filter filter) {
        return dsl.select()
                .from(RATING)
                .where(RATING.PLAYER_ID.eq(filter.getPlayerId()))
                .and(RATING.DISCIPLINE.eq(filter.getDiscipline().name()))
                .and(RATING.SEASON_ID.eq(filter.getSeasonId()))
                .fetchOneInto(Rating.class);
    }

    @Override
    public long save(Rating rating) {
        ratingDao.insert(rating);
        return rating.getId();
    }

    @Override
    public void update(Rating rating) {
        ratingDao.update(rating);
    }
}
