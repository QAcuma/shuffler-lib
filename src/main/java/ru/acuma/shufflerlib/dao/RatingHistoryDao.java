package ru.acuma.shufflerlib.dao;

import ru.acuma.k.shuffler.tables.pojos.RatingHistory;
import ru.acuma.shufflerlib.model.Filter;

import java.util.List;

public interface RatingHistoryDao {

    long save(RatingHistory ratingHistory);

    List<RatingHistory> findAllByPlayerId(Long playerId, Filter filter);

    List<RatingHistory> findAllByPlayersId(List<Long> playersId);

}
