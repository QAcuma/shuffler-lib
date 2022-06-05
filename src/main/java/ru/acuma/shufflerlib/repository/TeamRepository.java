package ru.acuma.shufflerlib.repository;

import ru.acuma.shuffler.tables.pojos.Team;

import java.util.List;

public interface TeamRepository {

    long save(Team team);

    long update(Team team);

    List<Team> saveAll(List<Team> teams);

    List<Team> findAllByPlayerId(Long playerId);

}
