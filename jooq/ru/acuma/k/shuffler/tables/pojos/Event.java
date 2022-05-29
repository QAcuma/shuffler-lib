/*
 * This file is generated by jOOQ.
 */
package ru.acuma.k.shuffler.tables.pojos;


import java.io.Serializable;
import java.time.OffsetDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long           id;
    private Long           chatId;
    private Long           seasonId;
    private String         state;
    private String         discipline;
    private OffsetDateTime startedAt;
    private OffsetDateTime finishedAt;

    public Event() {}

    public Event(Event value) {
        this.id = value.id;
        this.chatId = value.chatId;
        this.seasonId = value.seasonId;
        this.state = value.state;
        this.discipline = value.discipline;
        this.startedAt = value.startedAt;
        this.finishedAt = value.finishedAt;
    }

    public Event(
        Long           id,
        Long           chatId,
        Long           seasonId,
        String         state,
        String         discipline,
        OffsetDateTime startedAt,
        OffsetDateTime finishedAt
    ) {
        this.id = id;
        this.chatId = chatId;
        this.seasonId = seasonId;
        this.state = state;
        this.discipline = discipline;
        this.startedAt = startedAt;
        this.finishedAt = finishedAt;
    }

    /**
     * Getter for <code>public.event.id</code>.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Setter for <code>public.event.id</code>.
     */
    public Event setId(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Getter for <code>public.event.chat_id</code>.
     */
    public Long getChatId() {
        return this.chatId;
    }

    /**
     * Setter for <code>public.event.chat_id</code>.
     */
    public Event setChatId(Long chatId) {
        this.chatId = chatId;
        return this;
    }

    /**
     * Getter for <code>public.event.season_id</code>.
     */
    public Long getSeasonId() {
        return this.seasonId;
    }

    /**
     * Setter for <code>public.event.season_id</code>.
     */
    public Event setSeasonId(Long seasonId) {
        this.seasonId = seasonId;
        return this;
    }

    /**
     * Getter for <code>public.event.state</code>.
     */
    public String getState() {
        return this.state;
    }

    /**
     * Setter for <code>public.event.state</code>.
     */
    public Event setState(String state) {
        this.state = state;
        return this;
    }

    /**
     * Getter for <code>public.event.discipline</code>.
     */
    public String getDiscipline() {
        return this.discipline;
    }

    /**
     * Setter for <code>public.event.discipline</code>.
     */
    public Event setDiscipline(String discipline) {
        this.discipline = discipline;
        return this;
    }

    /**
     * Getter for <code>public.event.started_at</code>.
     */
    public OffsetDateTime getStartedAt() {
        return this.startedAt;
    }

    /**
     * Setter for <code>public.event.started_at</code>.
     */
    public Event setStartedAt(OffsetDateTime startedAt) {
        this.startedAt = startedAt;
        return this;
    }

    /**
     * Getter for <code>public.event.finished_at</code>.
     */
    public OffsetDateTime getFinishedAt() {
        return this.finishedAt;
    }

    /**
     * Setter for <code>public.event.finished_at</code>.
     */
    public Event setFinishedAt(OffsetDateTime finishedAt) {
        this.finishedAt = finishedAt;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Event (");

        sb.append(id);
        sb.append(", ").append(chatId);
        sb.append(", ").append(seasonId);
        sb.append(", ").append(state);
        sb.append(", ").append(discipline);
        sb.append(", ").append(startedAt);
        sb.append(", ").append(finishedAt);

        sb.append(")");
        return sb.toString();
    }
}
