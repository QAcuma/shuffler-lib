package ru.acuma.shufflerlib.repository.impl;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.acuma.shuffler.tables.daos.TeamDao;
import ru.acuma.shuffler.tables.pojos.Team;
import ru.acuma.shufflerlib.repository.TeamRepository;

import java.util.List;

import static ru.acuma.shuffler.Tables.TEAM;
import static ru.acuma.shuffler.Tables.TEAM_PLAYER;

@Repository
@RequiredArgsConstructor
public class TeamRepositoryImpl implements TeamRepository {

    private final DSLContext dsl;

    private TeamDao teamDao;

    @PostConstruct
    private void initTeamDao() {
        teamDao = new TeamDao(dsl.configuration());
    }

    @Override
    public long save(Team team) {
        teamDao.insert(team);
        return team.getId();
    }

    @Override
    public long update(Team team) {
        teamDao.update(team);
        return team.getId();
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
