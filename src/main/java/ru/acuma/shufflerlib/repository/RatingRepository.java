package ru.acuma.shufflerlib.repository;

import ru.acuma.shuffler.tables.pojos.Rating;
import ru.acuma.shufflerlib.model.Discipline;

public interface RatingRepository {

    long save(Rating rating);

    void update(Rating rating);


    Rating getRating(Long playerId, Discipline discipline);

}
