package ru.acuma.shufflerlib.repository;

import ru.acuma.shuffler.tables.pojos.Season;

public interface SeasonRepository {

    Season getCurrentSeason();

    void startNewSeason(String name);

}
