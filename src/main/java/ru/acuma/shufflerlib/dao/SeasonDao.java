package ru.acuma.shufflerlib.dao;

import ru.acuma.shuffler.tables.pojos.Season;

public interface SeasonDao {

    Season getCurrentSeason();

    void startNewSeason(String name);

}
