/*
 * This file is generated by jOOQ.
 */
package ru.acuma.shuffler.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({"all", "unchecked", "rawtypes"})
public class Rating implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long playerId;
    private Long seasonId;
    private String discipline;
    private Integer score;
    private Boolean isCalibrated;

    public Rating() {
    }

    public Rating(Rating value) {
        this.id = value.id;
        this.playerId = value.playerId;
        this.seasonId = value.seasonId;
        this.discipline = value.discipline;
        this.score = value.score;
        this.isCalibrated = value.isCalibrated;
    }

    public Rating(
            Long id,
            Long playerId,
            Long seasonId,
            String discipline,
            Integer score,
            Boolean isCalibrated
    ) {
        this.id = id;
        this.playerId = playerId;
        this.seasonId = seasonId;
        this.discipline = discipline;
        this.score = score;
        this.isCalibrated = isCalibrated;
    }

    /**
     * Getter for <code>public.rating.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.rating.id</code>.
     */
    public Rating setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>public.rating.player_id</code>.
     */
    public Long getPlayerId() {
        return this.playerId;
    }

    /**
     * Setter for <code>public.rating.player_id</code>.
     */
    public Rating setPlayerId(Long playerId) {
        this.playerId = playerId;
        return this;
    }

    /**
     * Getter for <code>public.rating.season_id</code>.
     */
    public Long getSeasonId() {
        return this.seasonId;
    }

    /**
     * Setter for <code>public.rating.season_id</code>.
     */
    public Rating setSeasonId(Long seasonId) {
        this.seasonId = seasonId;
        return this;
    }

    /**
     * Getter for <code>public.rating.discipline</code>.
     */
    public String getDiscipline() {
        return this.discipline;
    }

    /**
     * Setter for <code>public.rating.discipline</code>.
     */
    public Rating setDiscipline(String discipline) {
        this.discipline = discipline;
        return this;
    }

    /**
     * Getter for <code>public.rating.score</code>.
     */
    public Integer getScore() {
        return this.score;
    }

    /**
     * Setter for <code>public.rating.score</code>.
     */
    public Rating setScore(Integer score) {
        this.score = score;
        return this;
    }

    /**
     * Getter for <code>public.rating.is_calibrated</code>.
     */
    public Boolean getIsCalibrated() {
        return this.isCalibrated;
    }

    /**
     * Setter for <code>public.rating.is_calibrated</code>.
     */
    public Rating setIsCalibrated(Boolean isCalibrated) {
        this.isCalibrated = isCalibrated;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Rating (");

        sb.append(id);
        sb.append(", ").append(playerId);
        sb.append(", ").append(seasonId);
        sb.append(", ").append(discipline);
        sb.append(", ").append(score);
        sb.append(", ").append(isCalibrated);

        sb.append(")");
        return sb.toString();
    }
}
