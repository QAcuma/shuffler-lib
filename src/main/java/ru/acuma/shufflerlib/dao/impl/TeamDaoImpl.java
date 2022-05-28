package ru.acuma.shufflerlib.dao.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.acuma.k.shuffler.tables.pojos.Team;
import ru.acuma.shufflerlib.dao.TeamDao;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TeamDaoImpl implements TeamDao {

    private final DSLContext dsl;

    @Override
    public void save(Team team) {

    }

    @Override
    public List<Team> findAllByPlayerId(Long playerId) {
        return null;
    }
}
