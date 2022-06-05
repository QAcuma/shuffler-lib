/*
 * This file is generated by jOOQ.
 */
package ru.acuma.shuffler.tables.daos;


import java.util.List;
import java.util.Optional;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ru.acuma.shuffler.tables.RatingHistory;
import ru.acuma.shuffler.tables.records.RatingHistoryRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
@Repository
public class RatingHistoryDao extends DAOImpl<RatingHistoryRecord, ru.acuma.shuffler.tables.pojos.RatingHistory, Long> {

    /**
     * Create a new RatingHistoryDao without any configuration
     */
    public RatingHistoryDao() {
        super(RatingHistory.RATING_HISTORY, ru.acuma.shuffler.tables.pojos.RatingHistory.class);
    }

    /**
     * Create a new RatingHistoryDao with an attached configuration
     */
    @Autowired
    public RatingHistoryDao(Configuration configuration) {
        super(RatingHistory.RATING_HISTORY, ru.acuma.shuffler.tables.pojos.RatingHistory.class, configuration);
    }

    @Override
    public Long getId(ru.acuma.shuffler.tables.pojos.RatingHistory object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<ru.acuma.shuffler.tables.pojos.RatingHistory> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(RatingHistory.RATING_HISTORY.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<ru.acuma.shuffler.tables.pojos.RatingHistory> fetchById(Long... values) {
        return fetch(RatingHistory.RATING_HISTORY.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public ru.acuma.shuffler.tables.pojos.RatingHistory fetchOneById(Long value) {
        return fetchOne(RatingHistory.RATING_HISTORY.ID, value);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public Optional<ru.acuma.shuffler.tables.pojos.RatingHistory> fetchOptionalById(Long value) {
        return fetchOptional(RatingHistory.RATING_HISTORY.ID, value);
    }

    /**
     * Fetch records that have <code>game_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<ru.acuma.shuffler.tables.pojos.RatingHistory> fetchRangeOfGameId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(RatingHistory.RATING_HISTORY.GAME_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>game_id IN (values)</code>
     */
    public List<ru.acuma.shuffler.tables.pojos.RatingHistory> fetchByGameId(Long... values) {
        return fetch(RatingHistory.RATING_HISTORY.GAME_ID, values);
    }

    /**
     * Fetch records that have <code>player_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<ru.acuma.shuffler.tables.pojos.RatingHistory> fetchRangeOfPlayerId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(RatingHistory.RATING_HISTORY.PLAYER_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>player_id IN (values)</code>
     */
    public List<ru.acuma.shuffler.tables.pojos.RatingHistory> fetchByPlayerId(Long... values) {
        return fetch(RatingHistory.RATING_HISTORY.PLAYER_ID, values);
    }

    /**
     * Fetch records that have <code>change BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<ru.acuma.shuffler.tables.pojos.RatingHistory> fetchRangeOfChange(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(RatingHistory.RATING_HISTORY.CHANGE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>change IN (values)</code>
     */
    public List<ru.acuma.shuffler.tables.pojos.RatingHistory> fetchByChange(Integer... values) {
        return fetch(RatingHistory.RATING_HISTORY.CHANGE, values);
    }

    /**
     * Fetch records that have <code>score BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<ru.acuma.shuffler.tables.pojos.RatingHistory> fetchRangeOfScore(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(RatingHistory.RATING_HISTORY.SCORE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>score IN (values)</code>
     */
    public List<ru.acuma.shuffler.tables.pojos.RatingHistory> fetchByScore(Integer... values) {
        return fetch(RatingHistory.RATING_HISTORY.SCORE, values);
    }
}