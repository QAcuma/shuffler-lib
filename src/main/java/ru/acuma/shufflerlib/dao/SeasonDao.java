package ru.acuma.shufflerlib.dao;

import ru.acuma.k.shuffler.tables.pojos.Season;

public interface SeasonDao {

    Season getCurrentSeason();

    void startNewSeason(String name);

}
