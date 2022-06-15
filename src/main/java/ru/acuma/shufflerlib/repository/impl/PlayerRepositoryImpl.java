package ru.acuma.shufflerlib.repository.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.acuma.shuffler.tables.daos.PlayerDao;
import ru.acuma.shuffler.tables.pojos.Player;
import ru.acuma.shufflerlib.model.Filter;
import ru.acuma.shufflerlib.model.web.entity.WebPlayerDetails;
import ru.acuma.shufflerlib.repository.PlayerRepository;
import ru.acuma.shufflerlib.repository.util.FilterUtil;

import javax.annotation.PostConstruct;

import static org.jooq.impl.DSL.concat;
import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.selectCount;
import static org.jooq.impl.DSL.substring;
import static org.jooq.impl.DSL.val;
import static org.jooq.impl.DSL.when;
import static ru.acuma.shuffler.Tables.EVENT;
import static ru.acuma.shuffler.Tables.GAME;
import static ru.acuma.shuffler.Tables.RATING;
import static ru.acuma.shuffler.Tables.TEAM;
import static ru.acuma.shuffler.Tables.TEAM_PLAYER;
import static ru.acuma.shuffler.tables.Player.PLAYER;
import static ru.acuma.shuffler.tables.UserInfo.USER_INFO;

@Log4j2
@Repository
@RequiredArgsConstructor
public class PlayerRepositoryImpl implements PlayerRepository {

    private final DSLContext dsl;
    private PlayerDao playerDao;

    @PostConstruct
    void initPlayerDao() {
        playerDao = new PlayerDao(dsl.configuration());
    }

    @Override
    public boolean isPresent(Long chatId, Long userId) {
        return dsl.fetchExists(
                dsl.selectFrom(PLAYER)
                        .where(PLAYER.CHAT_ID.eq(chatId))
                        .and(PLAYER.USER_ID.eq(userId))
        );
    }

    @Override
    public Player get(Long chatId, Long userId) {
        return dsl.select()
                .from(PLAYER)
                .where(PLAYER.CHAT_ID.eq(chatId))
                .and(PLAYER.USER_ID.eq(userId))
                .fetchOneInto(Player.class);
    }

    @Override
    public long save(Player player) {
        playerDao.update(player);
        return player.getId();
    }

    @Override
    public WebPlayerDetails findPlayerInfo(Filter filter) {
        return dsl.select(
                        PLAYER.ID,
                        concat(
                                when(USER_INFO.FIRST_NAME.isNotNull(), USER_INFO.FIRST_NAME).otherwise(""),
                                val(" "),
                                when(USER_INFO.LAST_NAME.isNotNull(), substring(USER_INFO.LAST_NAME, 0, 2).concat(".")).otherwise("")
                        ).as("name"),
                        RATING.SCORE,
                        field(
                                selectCount()
                                        .from(TEAM)
                                        .join(TEAM_PLAYER).on(TEAM_PLAYER.TEAM_ID.eq(TEAM.ID))
                                        .join(GAME).on(GAME.ID.eq(TEAM.GAME_ID))
                                        .join(EVENT).on(EVENT.ID.eq(GAME.EVENT_ID))
                                        .where(TEAM.IS_WINNER.eq(Boolean.TRUE))
                                        .and(FilterUtil.playerDisciplineSeasonGameStateCondition(filter))
                        ).as("winCount"),
                        field(
                                selectCount()
                                        .from(TEAM)
                                        .join(TEAM_PLAYER).on(TEAM_PLAYER.TEAM_ID.eq(TEAM.ID))
                                        .join(GAME).on(GAME.ID.eq(TEAM.GAME_ID))
                                        .join(EVENT).on(EVENT.ID.eq(GAME.EVENT_ID))
                                        .where(TEAM.IS_WINNER.eq(Boolean.FALSE))
                                        .and(FilterUtil.playerDisciplineSeasonGameStateCondition(filter))
                        ).as("loseCount")
                )
                .from(PLAYER)
                .join(USER_INFO).on(USER_INFO.TELEGRAM_ID.eq(PLAYER.USER_ID))
                .join(RATING).on(RATING.PLAYER_ID.eq(PLAYER.ID))
                .where(RATING.DISCIPLINE.eq(filter.getDiscipline().name()))
                .and(PLAYER.ID.eq(filter.getPlayerId()))
                .fetchOneInto(WebPlayerDetails.class);
    }

}
