package ru.acuma.shufflerlib.repository.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.acuma.shuffler.tables.pojos.Season;
import ru.acuma.shufflerlib.repository.SeasonRepository;

import java.time.OffsetDateTime;
import java.util.List;

import static ru.acuma.shuffler.Tables.SEASON;


@Repository
@RequiredArgsConstructor
public class SeasonRepositoryImpl implements SeasonRepository {

    private final DSLContext dsl;

    @Override
    public Season getCurrentSeason() {
        return dsl.selectFrom(SEASON)
                .where(SEASON.FINISHED_AT.isNull())
                .fetchOneInto(Season.class);
    }

    @Override
    public void startNewSeason(String name) {
        dsl.update(SEASON)
                .set(SEASON.FINISHED_AT, OffsetDateTime.now())
                .where(SEASON.FINISHED_AT.isNull())
                .execute();

        Season season = new Season()
                .setStartedAt(OffsetDateTime.now())
                .setName(name);
        dsl.newRecord(SEASON, season).store();
    }

    @Override
    public List<Season> findSeasons() {
        return dsl.selectFrom(SEASON)
                .orderBy(SEASON.STARTED_AT.desc())
                .limit(10)
                .fetchInto(Season.class);
    }

}
