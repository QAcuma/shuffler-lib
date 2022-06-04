package ru.acuma.shufflerlib.dao;

import ru.acuma.shuffler.tables.pojos.Rating;
import ru.acuma.shufflerlib.model.Discipline;

public interface RatingDao {

    long save(Rating rating);

    void update(Rating rating);


    Rating getRating(Long playerId, Discipline discipline);

}
