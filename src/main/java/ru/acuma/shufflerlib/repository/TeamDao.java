package ru.acuma.shufflerlib.repository;

import ru.acuma.shuffler.tables.pojos.Team;

import java.util.List;

public interface TeamDao {

    long save(Team team);

    List<Team> saveAll(List<Team> teams);

    List<Team> findAllByPlayerId(Long playerId);

}
