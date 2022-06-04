package ru.acuma.shufflerlib.repository.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.acuma.shuffler.tables.pojos.Team;
import ru.acuma.shuffler.tables.records.TeamRecord;
import ru.acuma.shufflerlib.repository.TeamDao;

import java.util.List;

import static ru.acuma.shuffler.Tables.TEAM;
import static ru.acuma.shuffler.Tables.TEAM_PLAYER;

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
        return dsl.select(TEAM.fields())
                .from(TEAM)
                .join(TEAM_PLAYER).on(TEAM_PLAYER.TEAM_ID.eq(TEAM.ID))
                .where(TEAM_PLAYER.PLAYER_ID.eq(playerId))
                .fetchInto(Team.class);
    }
}
