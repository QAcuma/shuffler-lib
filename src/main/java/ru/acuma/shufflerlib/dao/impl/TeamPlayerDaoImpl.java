package ru.acuma.shufflerlib.dao.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Component;
import ru.acuma.shuffler.tables.pojos.TeamPlayer;
import ru.acuma.shuffler.tables.records.TeamPlayerRecord;
import ru.acuma.shufflerlib.dao.TeamPlayerDao;

import static ru.acuma.shuffler.Tables.TEAM_PLAYER;

@Component
@RequiredArgsConstructor
public class TeamPlayerDaoImpl implements TeamPlayerDao {

    private final DSLContext dsl;

    @Override
    public long save(TeamPlayer teamPlayer) {
        TeamPlayerRecord record = dsl.newRecord(TEAM_PLAYER, teamPlayer);
        record.store();
        return record.getId();
    }
}
