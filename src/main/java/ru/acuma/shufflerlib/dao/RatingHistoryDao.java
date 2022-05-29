package ru.acuma.shufflerlib.dao;

import ru.acuma.k.shuffler.tables.pojos.RatingHistory;

import java.util.List;

public interface RatingHistoryDao {

    long save(RatingHistory ratingHistory);

    List<RatingHistory> findAllByPlayerId(Long playerId);

    List<RatingHistory> findAllByPlayersId(List<Long> playersId);

}
