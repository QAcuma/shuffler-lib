package ru.acuma.shufflerlib.dao.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.acuma.k.shuffler.tables.pojos.Team;
import ru.acuma.k.shuffler.tables.records.TeamRecord;
import ru.acuma.shufflerlib.dao.TeamDao;

import java.util.List;

import static ru.acuma.k.shuffler.Tables.TEAM;

@Repository
@RequiredArgsConstructor
public class TeamDaoImpl implements TeamDao {

    private final DSLContext dsl;

    @Override
    public long save(Team team) {
        TeamRecord record = dsl.newRecord(TEAM, team);
        record.store();
        return record.getId();
    }

    @Override
    public List<Team> saveAll(List<Team> teams) {
        teams.forEach(t -> t.setId(save(t)));
        return teams;
    }

    @Override
    public List<Team> findAllByPlayerId(Long playerId) {
        return null;
    }
}
