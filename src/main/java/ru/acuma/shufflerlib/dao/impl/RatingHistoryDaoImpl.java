package ru.acuma.shufflerlib.dao.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.acuma.shuffler.tables.pojos.RatingHistory;
import ru.acuma.shuffler.tables.records.RatingHistoryRecord;
import ru.acuma.shufflerlib.dao.RatingHistoryDao;
import ru.acuma.shufflerlib.model.Filter;

import java.util.List;

import static ru.acuma.shuffler.Tables.RATING_HISTORY;

@Repository
@RequiredArgsConstructor
public class RatingHistoryDaoImpl implements RatingHistoryDao {

    private final DSLContext dsl;

    @Override
    public long save(RatingHistory ratingHistory) {
        RatingHistoryRecord record = dsl.newRecord(RATING_HISTORY, ratingHistory);
        record.store();
        return record.getId();
    }

    @Override
    public List<RatingHistory> findAllByPlayerId(Long playerId, Filter filter) {
//        return dsl.selectFrom(RATING_HISTORY)
//                .where(RATING_HISTORY.PLAYER_ID.eq(playerId))
//                .and()
        return null;
    }

    @Override
    public List<RatingHistory> findAllByPlayersId(List<Long> playersId) {
        return null;
    }
}
