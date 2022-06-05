/*
 * This file is generated by jOOQ.
 */
package ru.acuma.shuffler.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Team implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long    id;
    private Long    gameId;
    private Boolean isWinner;

    public Team() {}

    public Team(Team value) {
        this.id = value.id;
        this.gameId = value.gameId;
        this.isWinner = value.isWinner;
    }

    public Team(
        Long    id,
        Long    gameId,
        Boolean isWinner
    ) {
        this.id = id;
        this.gameId = gameId;
        this.isWinner = isWinner;
    }

    /**
     * Getter for <code>public.team.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.team.id</code>.
     */
    public Team setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>public.team.game_id</code>.
     */
    public Long getGameId() {
        return this.gameId;
    }

    /**
     * Setter for <code>public.team.game_id</code>.
     */
    public Team setGameId(Long gameId) {
        this.gameId = gameId;
        return this;
    }

    /**
     * Getter for <code>public.team.is_winner</code>.
     */
    public Boolean getIsWinner() {
        return this.isWinner;
    }

    /**
     * Setter for <code>public.team.is_winner</code>.
     */
    public Team setIsWinner(Boolean isWinner) {
        this.isWinner = isWinner;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Team (");

        sb.append(id);
        sb.append(", ").append(gameId);
        sb.append(", ").append(isWinner);

        sb.append(")");
        return sb.toString();
    }
}
