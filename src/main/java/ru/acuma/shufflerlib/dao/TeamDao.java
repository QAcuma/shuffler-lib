package ru.acuma.shufflerlib.dao;

import ru.acuma.k.shuffler.tables.pojos.Team;

import java.util.List;

public interface TeamDao {

    void save(Team team);

    List<Team> findAllByPlayerId(Long playerId);

}
