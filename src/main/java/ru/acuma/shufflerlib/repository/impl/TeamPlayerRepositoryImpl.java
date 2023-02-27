package ru.acuma.shufflerlib.repository.impl;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.acuma.shuffler.tables.daos.TeamPlayerDao;
import ru.acuma.shuffler.tables.pojos.TeamPlayer;
import ru.acuma.shufflerlib.repository.TeamPlayerRepository;

@Repository
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
