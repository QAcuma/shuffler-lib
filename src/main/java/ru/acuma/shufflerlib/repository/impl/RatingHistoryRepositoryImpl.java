package ru.acuma.shufflerlib.repository.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.acuma.shuffler.tables.daos.RatingHistoryDao;
import ru.acuma.shuffler.tables.pojos.RatingHistory;
import ru.acuma.shufflerlib.model.Filter;
import ru.acuma.shufflerlib.model.web.WebGame;
import ru.acuma.shufflerlib.model.web.WebPlayer;
import ru.acuma.shufflerlib.model.web.WebTeam;
import ru.acuma.shufflerlib.repository.RatingHistoryRepository;

import javax.annotation.PostConstruct;
import java.util.List;

import static org.jooq.Records.mapping;
import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.multiset;
import static org.jooq.impl.DSL.noCondition;
import static org.jooq.impl.DSL.select;
import static ru.acuma.shuffler.tables.Game.GAME;
import static ru.acuma.shuffler.tables.Player.PLAYER;
import static ru.acuma.shuffler.tables.RatingHistory.RATING_HISTORY;
import static ru.acuma.shuffler.tables.Team.TEAM;
import static ru.acuma.shuffler.tables.TeamPlayer.TEAM_PLAYER;
import static ru.acuma.shuffler.tables.UserInfo.USER_INFO;

@Repository
@RequiredArgsConstructor
public class RatingHistoryRepositoryImpl implements RatingHistoryRepository {

    private final DSLContext dsl;

    private RatingHistoryDao historyDao;

    @PostConstruct
    void initGameDao() {
        historyDao = new RatingHistoryDao(dsl.configuration());
    }

    @Override
    public long save(RatingHistory ratingHistory) {
        historyDao.insert(ratingHistory);
        return ratingHistory.getId();
    }

    @Override
    public List<WebGame> findHistory(Filter filter) {
        return dsl.select(
                        GAME.ID,
                        GAME.FINISHED_AT,
                        RATING_HISTORY.CHANGE,
                        multiset(
                                select(
                                        TEAM.IS_WINNER,
                                        multiset(
                                                select(
                                                        TEAM_PLAYER.ID,
                                                        field(
                                                                select(
                                                                        USER_INFO.FIRST_NAME
                                                                )
                                                                        .from(PLAYER)
                                                                        .join(USER_INFO).on(USER_INFO.TELEGRAM_ID.eq(PLAYER.USER_ID))
                                                                        .where(PLAYER.ID.eq(TEAM_PLAYER.PLAYER_ID))
                                                        ),
                                                        field(
                                                                select(
                                                                        RATING_HISTORY.SCORE
                                                                )
                                                                        .from(RATING_HISTORY)
                                                                        .join(USER_INFO).on(USER_INFO.TELEGRAM_ID.eq(PLAYER.USER_ID))
                                                                        .where(RATING_HISTORY.PLAYER_ID.eq(TEAM_PLAYER.ID))
                                                        )
                                                )
                                                        .from(TEAM_PLAYER)
                                                        .where(TEAM_PLAYER.TEAM_ID.eq(TEAM.ID))
                                        ).as("players").convertFrom(r -> r.map(mapping(WebPlayer::new)))
                                )
                                        .from(TEAM)
                                        .where(TEAM.GAME_ID.eq(GAME.ID))
                        ).as("teams").convertFrom(r -> r.map(mapping(WebTeam::new)))
                )
                .from(GAME)
                .join(RATING_HISTORY).on(RATING_HISTORY.GAME_ID.eq(GAME.ID))
                .join(PLAYER).on(PLAYER.ID.eq(RATING_HISTORY.PLAYER_ID))
//                .where(RATING_HISTORY.PLAYER_ID.eq(filter.getPlayerId()))
                .fetchInto(WebGame.class);

//        return null;

    }

//    public Condition condition(Filter filter) {
//        Condition result = noCondition();
//
//        if (filter.getChatId() != null)
//            result = result.and(BOOK.TITLE.like("%" + request.getParameter("title") + "%"));
//
//        if (request.getParameter("author") != null)
//            result = result.and(BOOK.AUTHOR_ID.in(
//                    selectOne().from(AUTHOR).where(
//                            AUTHOR.FIRST_NAME.like("%" + request.getParameter("author") + "%")
//                                    .or(AUTHOR.LAST_NAME.like("%" + request.getParameter("author") + "%"))
//                    )
//            ));
//
//        return result;
//    }

}
