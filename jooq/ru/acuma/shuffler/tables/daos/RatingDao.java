/*
 * This file is generated by jOOQ.
 */
package ru.acuma.shuffler.tables.daos;


import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.acuma.shuffler.tables.Rating;
import ru.acuma.shuffler.tables.records.RatingRecord;

import java.util.List;
import java.util.Optional;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
@Repository
public class RatingDao extends DAOImpl<RatingRecord, ru.acuma.shuffler.tables.pojos.Rating, Long> {

    /**
     * Create a new RatingDao without any configuration
     */
    public RatingDao() {
        super(Rating.RATING, ru.acuma.shuffler.tables.pojos.Rating.class);
    }

    /**
     * Create a new RatingDao with an attached configuration
     */
    @Autowired
    public RatingDao(Configuration configuration) {
        super(Rating.RATING, ru.acuma.shuffler.tables.pojos.Rating.class, configuration);
    }

    @Override
    public Long getId(ru.acuma.shuffler.tables.pojos.Rating object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<ru.acuma.shuffler.tables.pojos.Rating> fetchRangeOfId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Rating.RATING.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<ru.acuma.shuffler.tables.pojos.Rating> fetchById(Long... values) {
        return fetch(Rating.RATING.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public ru.acuma.shuffler.tables.pojos.Rating fetchOneById(Long value) {
        return fetchOne(Rating.RATING.ID, value);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public Optional<ru.acuma.shuffler.tables.pojos.Rating> fetchOptionalById(Long value) {
        return fetchOptional(Rating.RATING.ID, value);
    }

    /**
     * Fetch records that have <code>player_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<ru.acuma.shuffler.tables.pojos.Rating> fetchRangeOfPlayerId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Rating.RATING.PLAYER_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>player_id IN (values)</code>
     */
    public List<ru.acuma.shuffler.tables.pojos.Rating> fetchByPlayerId(Long... values) {
        return fetch(Rating.RATING.PLAYER_ID, values);
    }

    /**
     * Fetch records that have <code>season_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<ru.acuma.shuffler.tables.pojos.Rating> fetchRangeOfSeasonId(Long lowerInclusive, Long upperInclusive) {
        return fetchRange(Rating.RATING.SEASON_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>season_id IN (values)</code>
     */
    public List<ru.acuma.shuffler.tables.pojos.Rating> fetchBySeasonId(Long... values) {
        return fetch(Rating.RATING.SEASON_ID, values);
    }

    /**
     * Fetch records that have <code>discipline BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<ru.acuma.shuffler.tables.pojos.Rating> fetchRangeOfDiscipline(String lowerInclusive, String upperInclusive) {
        return fetchRange(Rating.RATING.DISCIPLINE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>discipline IN (values)</code>
     */
    public List<ru.acuma.shuffler.tables.pojos.Rating> fetchByDiscipline(String... values) {
        return fetch(Rating.RATING.DISCIPLINE, values);
    }

    /**
     * Fetch records that have <code>score BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<ru.acuma.shuffler.tables.pojos.Rating> fetchRangeOfScore(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Rating.RATING.SCORE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>score IN (values)</code>
     */
    public List<ru.acuma.shuffler.tables.pojos.Rating> fetchByScore(Integer... values) {
        return fetch(Rating.RATING.SCORE, values);
    }

    /**
     * Fetch records that have <code>is_calibrated BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<ru.acuma.shuffler.tables.pojos.Rating> fetchRangeOfIsCalibrated(Boolean lowerInclusive, Boolean upperInclusive) {
        return fetchRange(Rating.RATING.IS_CALIBRATED, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>is_calibrated IN (values)</code>
     */
    public List<ru.acuma.shuffler.tables.pojos.Rating> fetchByIsCalibrated(Boolean... values) {
        return fetch(Rating.RATING.IS_CALIBRATED, values);
    }
}
