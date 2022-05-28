/*
 * This file is generated by jOOQ.
 */
package ru.acuma.k.shuffler.tables.pojos;


import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Player implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long chatId;
    private Long userId;
    private Long seasonId;
    private Long discipline;

    public Player() {}

    public Player(Player value) {
        this.id = value.id;
        this.chatId = value.chatId;
        this.userId = value.userId;
        this.seasonId = value.seasonId;
        this.discipline = value.discipline;
    }

    public Player(
        Long id,
        Long chatId,
        Long userId,
        Long seasonId,
        Long discipline
    ) {
        this.id = id;
        this.chatId = chatId;
        this.userId = userId;
        this.seasonId = seasonId;
        this.discipline = discipline;
    }

    /**
     * Getter for <code>public.player.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.player.id</code>.
     */
    public Player setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>public.player.chat_id</code>.
     */
    public Long getChatId() {
        return this.chatId;
    }

    /**
     * Setter for <code>public.player.chat_id</code>.
     */
    public Player setChatId(Long chatId) {
        this.chatId = chatId;
        return this;
    }

    /**
     * Getter for <code>public.player.user_id</code>.
     */
    public Long getUserId() {
        return this.userId;
    }

    /**
     * Setter for <code>public.player.user_id</code>.
     */
    public Player setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    /**
     * Getter for <code>public.player.season_id</code>.
     */
    public Long getSeasonId() {
        return this.seasonId;
    }

    /**
     * Setter for <code>public.player.season_id</code>.
     */
    public Player setSeasonId(Long seasonId) {
        this.seasonId = seasonId;
        return this;
    }

    /**
     * Getter for <code>public.player.discipline</code>.
     */
    public Long getDiscipline() {
        return this.discipline;
    }

    /**
     * Setter for <code>public.player.discipline</code>.
     */
    public Player setDiscipline(Long discipline) {
        this.discipline = discipline;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Player (");

        sb.append(id);
        sb.append(", ").append(chatId);
        sb.append(", ").append(userId);
        sb.append(", ").append(seasonId);
        sb.append(", ").append(discipline);

        sb.append(")");
        return sb.toString();
    }
}
