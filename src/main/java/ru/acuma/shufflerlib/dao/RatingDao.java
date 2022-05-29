package ru.acuma.shufflerlib.dao;

import ru.acuma.k.shuffler.tables.pojos.Rating;
import ru.acuma.shufflerlib.model.Discipline;

public interface RatingDao {

    long save(Rating rating);

    Rating getRating(Long playerId, Discipline discipline);

}
