package ru.acuma.shufflerlib.repository.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import ru.acuma.shuffler.tables.daos.RatingHistoryDao;
import ru.acuma.shuffler.tables.pojos.RatingHistory;
import ru.acuma.shufflerlib.model.Filter;
import ru.acuma.shufflerlib.model.web.entity.WebGame;
import ru.acuma.shufflerlib.model.web.entity.WebPlayer;
import ru.acuma.shufflerlib.model.web.entity.WebTeam;
import ru.acuma.shufflerlib.repository.RatingHistoryRepository;
import ru.acuma.shufflerlib.repository.util.FilterUtil;

import javax.annotation.PostConstruct;
import java.util.List;

import static org.jooq.Records.mapping;
import static org.jooq.impl.DSL.concat;
import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.multiset;
import static org.jooq.impl.DSL.select;
import static org.jooq.impl.DSL.substring;
import static org.jooq.impl.DSL.val;
import static org.jooq.impl.DSL.when;
import static ru.acuma.shuffler.Tables.EVENT;
import static ru.acuma.shuffler.Tables.GROUP_INFO;
import static ru.acuma.shuffler.tables.Game.GAME;
import static ru.acuma.shuffler.tables.Player.PLAYER;
import static ru.acuma.shuffler.tables.RatingHistory.RATING_HISTORY;
import static ru.acuma.shuffler.tables.Team.TEAM;
import static ru.acuma.shuffler.tables.TeamPlayer.TEAM_PLAYER;
import static ru.acuma.shuffler.tables.UserInfo.USER_INFO;

@Repository
@RequiredArgsConstructor
public class RatingHistoryRepositoryImpl implements RatingHistoryRepository {

    @Value("${media.link:localhost}")
    private String mediaLink;

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
                                                        TEAM_PLAYER.PLAYER_ID,
                                                        field(
                                                                select(
                                                                        concat(
                                                                                when(USER_INFO.FIRST_NAME.isNotNull(), USER_INFO.FIRST_NAME).otherwise(""),
                                                                                val(" "),
                                                                                when(USER_INFO.LAST_NAME.isNotNull(), substring(USER_INFO.LAST_NAME, 0, 2).concat(".")).otherwise("")
                                                                        )
                                                                )
                                                                        .from(PLAYER)
                                                                        .join(USER_INFO).on(USER_INFO.TELEGRAM_ID.eq(PLAYER.USER_ID))
                                                                        .where(PLAYER.ID.eq(TEAM_PLAYER.PLAYER_ID))
                                                        ).as("name"),
                                                        concat(
                                                                val(mediaLink),
                                                                field(
                                                                        select(
                                                                                USER_INFO.MEDIA_ID
                                                                        )
                                                                                .from(USER_INFO)
                                                                                .join(PLAYER).on(PLAYER.USER_ID.eq(USER_INFO.TELEGRAM_ID))
                                                                                .where(PLAYER.ID.eq(TEAM_PLAYER.PLAYER_ID)))
                                                        ).as("avatar"),
                                                        field(
                                                                select(
                                                                        RATING_HISTORY.SCORE
                                                                )
                                                                        .from(RATING_HISTORY)
                                                                        .where(RATING_HISTORY.PLAYER_ID.eq(TEAM_PLAYER.PLAYER_ID))
                                                                        .and(RATING_HISTORY.GAME_ID.eq(GAME.ID))
                                                        ).as("score")
                                                )
                                                        .from(TEAM_PLAYER)
                                                        .where(TEAM_PLAYER.TEAM_ID.eq(TEAM.ID))
                                        ).as("players").convertFrom(r -> r.map(mapping(WebPlayer::new)))
                                )
                                        .from(TEAM)
                                        .where(RATING_HISTORY.GAME_ID.eq(TEAM.GAME_ID))
                                        .orderBy(TEAM.ID)
                        ).as("teams").convertFrom(r -> r.map(mapping(WebTeam::new)))
                )
                .from(GAME)
                .join(EVENT).on(EVENT.ID.eq(GAME.EVENT_ID))
                .join(RATING_HISTORY).on(RATING_HISTORY.GAME_ID.eq(GAME.ID))
                .join(GROUP_INFO).on(GROUP_INFO.CHAT_ID.eq(EVENT.CHAT_ID))
                .where(FilterUtil.chatOrPlayerAndSeasonDisciplineCondition(filter))
                .orderBy(GAME.FINISHED_AT.desc())
                .fetchInto(WebGame.class);
    }

    @Override
    public int findGamesCountBySeasonIdAndPlayerId(Long seasonId, Long playerId) {
        return dsl.selectCount()
                .from(RATING_HISTORY)
                .where(RATING_HISTORY.SEASON_ID.eq(seasonId))
                .and(RATING_HISTORY.PLAYER_ID.eq(playerId))
                .execute();
    }

    @Override
    public List<RatingHistory> findHistoryBySeasonIdAndPlayerId(Long seasonId, Long playerId) {
        return dsl.selectCount()
                .from(RATING_HISTORY)
                .where(RATING_HISTORY.SEASON_ID.eq(seasonId))
                .and(RATING_HISTORY.GAME_ID.in(
                        select(RATING_HISTORY.GAME_ID)
                                .where(RATING_HISTORY.SEASON_ID.eq(seasonId))
                                .and(RATING_HISTORY.PLAYER_ID.eq(playerId)))
                )
                .fetchInto(RatingHistory.class);
    }

}
