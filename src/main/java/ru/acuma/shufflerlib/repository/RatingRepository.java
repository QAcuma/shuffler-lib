package ru.acuma.shufflerlib.repository;

import ru.acuma.shuffler.tables.pojos.Rating;
import ru.acuma.shufflerlib.model.Filter;

public interface RatingRepository {

    long save(Rating rating);

    void update(Rating rating);

    Rating getRatingByPlayerIdAndDisciplineAndSeasonId(Filter filter);

}
