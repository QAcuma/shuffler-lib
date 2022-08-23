package ru.acuma.shufflerlib.repository.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Component;
import ru.acuma.shuffler.tables.daos.TeamDao;
import ru.acuma.shuffler.tables.daos.TeamPlayerDao;
import ru.acuma.shuffler.tables.pojos.TeamPlayer;
import ru.acuma.shuffler.tables.records.TeamPlayerRecord;
import ru.acuma.shufflerlib.repository.TeamPlayerRepository;

import javax.annotation.PostConstruct;

import static ru.acuma.shuffler.Tables.TEAM_PLAYER;

@Component
@RequiredArgsConstructor
public class TeamPlayerRepositoryImpl implements TeamPlayerRepository {

    private final DSLContext dsl;

    private TeamPlayerDao teamPlayerDao;

    @PostConstruct
    private void initTeamDao() {
        teamPlayerDao = new TeamPlayerDao(dsl.configuration());
    }

    @Override
    public long save(TeamPlayer teamPlayer) {
        teamPlayerDao.insert(teamPlayer);

        return teamPlayer.getId();
    }
}
