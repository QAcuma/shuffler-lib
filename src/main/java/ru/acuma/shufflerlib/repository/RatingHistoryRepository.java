package ru.acuma.shufflerlib.repository;

import ru.acuma.shuffler.tables.pojos.RatingHistory;
import ru.acuma.shufflerlib.model.Discipline;
import ru.acuma.shufflerlib.model.Filter;
import ru.acuma.shufflerlib.model.web.entity.WebGame;

import java.util.List;

public interface RatingHistoryRepository {

    long save(RatingHistory ratingHistory);

    List<WebGame> findHistory(Filter filter);

    int findGamesCountBySeasonIdAndPlayerId(Long seasonId, Long playerId, Discipline discipline);

    List<RatingHistory> findHistoryBySeasonIdAndPlayerId(Long seasonId, Long playerId);

}
