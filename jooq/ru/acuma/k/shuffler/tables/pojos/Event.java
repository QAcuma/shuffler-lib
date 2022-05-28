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
    private String         status;
    private OffsetDateTime startedAt;
    private OffsetDateTime finishedAt;
    private String         discipline;
    private Long           seasonId;
    private Long           index;

    public Event() {}

    public Event(Event value) {
        this.id = value.id;
        this.chatId = value.chatId;
        this.status = value.status;
        this.startedAt = value.startedAt;
        this.finishedAt = value.finishedAt;
        this.discipline = value.discipline;
        this.seasonId = value.seasonId;
        this.index = value.index;
    }

    public Event(
        Long           id,
        Long           chatId,
        String         status,
        OffsetDateTime startedAt,
        OffsetDateTime finishedAt,
        String         discipline,
        Long           seasonId,
        Long           index
    ) {
        this.id = id;
        this.chatId = chatId;
        this.status = status;
        this.startedAt = startedAt;
        this.finishedAt = finishedAt;
        this.discipline = discipline;
        this.seasonId = seasonId;
        this.index = index;
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
     * Getter for <code>public.event.status</code>.
     */
    public String getStatus() {
        return this.status;
    }

    /**
     * Setter for <code>public.event.status</code>.
     */
    public Event setStatus(String status) {
        this.status = status;
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
     * Getter for <code>public.event.index</code>.
     */
    public Long getIndex() {
        return this.index;
    }

    /**
     * Setter for <code>public.event.index</code>.
     */
    public Event setIndex(Long index) {
        this.index = index;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Event (");

        sb.append(id);
        sb.append(", ").append(chatId);
        sb.append(", ").append(status);
        sb.append(", ").append(startedAt);
        sb.append(", ").append(finishedAt);
        sb.append(", ").append(discipline);
        sb.append(", ").append(seasonId);
        sb.append(", ").append(index);

        sb.append(")");
        return sb.toString();
    }
}
