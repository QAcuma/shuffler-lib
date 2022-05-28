package ru.acuma.shufflerlib.dao.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.acuma.k.shuffler.tables.pojos.Season;
import ru.acuma.shufflerlib.dao.SeasonDao;

import java.time.OffsetDateTime;

import static ru.acuma.k.shuffler.Tables.SEASON;


@Repository
@RequiredArgsConstructor
public class SeasonDaoImpl implements SeasonDao {

    private final DSLContext dsl;

    @Override
    public Season getCurrentSeason() {
        return dsl.selectFrom(SEASON)
                .where(SEASON.FINISHED_AT.isNull())
                .fetchOneInto(Season.class);
    }

    @Override
    @Transactional
    public void startNewSeason() {
        dsl.update(SEASON)
                .set(SEASON.FINISHED_AT, OffsetDateTime.now())
                .where(SEASON.FINISHED_AT.isNull())
                .execute();

        Season season = new Season();
        season.setStartedAt(OffsetDateTime.now());

        dsl.newRecord(SEASON, season).store();
    }

}
