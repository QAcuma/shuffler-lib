package ru.acuma.shufflerlib.dao;

import ru.acuma.k.shuffler.tables.pojos.Rating;
import ru.acuma.shufflerlib.model.Discipline;

public interface RatingDao {

    Rating getRating(Long playerId, Discipline discipline);

    void save(Rating rating);

}
