package ru.acuma.shufflerlib.repository;

import ru.acuma.shuffler.tables.pojos.Season;

import java.util.List;

public interface SeasonRepository {

    Season getCurrentSeason();

    void startNewSeason(String name);

    List<Season> findSeasons();

}
