package ru.acuma.shufflerlib.repository;

import ru.acuma.shuffler.tables.pojos.RatingHistory;
import ru.acuma.shufflerlib.model.Filter;

import java.util.List;

public interface RatingHistoryRepository {

    long save(RatingHistory ratingHistory);

    List<RatingHistory> findAllByPlayerId(Long playerId, Filter filter);

    List<RatingHistory> findAllByPlayersId(List<Long> playersId);

}
