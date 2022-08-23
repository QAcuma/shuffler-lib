/*
 * This file is generated by jOOQ.
 */
package ru.acuma.shuffler;


import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;

import ru.acuma.shuffler.tables.Event;
import ru.acuma.shuffler.tables.FlywaySchemaHistory;
import ru.acuma.shuffler.tables.Game;
import ru.acuma.shuffler.tables.GroupInfo;
import ru.acuma.shuffler.tables.Player;
import ru.acuma.shuffler.tables.Rating;
import ru.acuma.shuffler.tables.RatingHistory;
import ru.acuma.shuffler.tables.Season;
import ru.acuma.shuffler.tables.Team;
import ru.acuma.shuffler.tables.TeamPlayer;
import ru.acuma.shuffler.tables.UserInfo;
import ru.acuma.shuffler.tables.records.EventRecord;
import ru.acuma.shuffler.tables.records.FlywaySchemaHistoryRecord;
import ru.acuma.shuffler.tables.records.GameRecord;
import ru.acuma.shuffler.tables.records.GroupInfoRecord;
import ru.acuma.shuffler.tables.records.PlayerRecord;
import ru.acuma.shuffler.tables.records.RatingHistoryRecord;
import ru.acuma.shuffler.tables.records.RatingRecord;
import ru.acuma.shuffler.tables.records.SeasonRecord;
import ru.acuma.shuffler.tables.records.TeamPlayerRecord;
import ru.acuma.shuffler.tables.records.TeamRecord;
import ru.acuma.shuffler.tables.records.UserInfoRecord;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<EventRecord> EVENT_PKEY = Internal.createUniqueKey(Event.EVENT, DSL.name("event_pkey"), new TableField[] { Event.EVENT.ID }, true);
    public static final UniqueKey<FlywaySchemaHistoryRecord> FLYWAY_SCHEMA_HISTORY_PK = Internal.createUniqueKey(FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY, DSL.name("flyway_schema_history_pk"), new TableField[] { FlywaySchemaHistory.FLYWAY_SCHEMA_HISTORY.INSTALLED_RANK }, true);
    public static final UniqueKey<GameRecord> GAME_PKEY = Internal.createUniqueKey(Game.GAME, DSL.name("game_pkey"), new TableField[] { Game.GAME.ID }, true);
    public static final UniqueKey<GroupInfoRecord> GROUP_INFO_PKEY = Internal.createUniqueKey(GroupInfo.GROUP_INFO, DSL.name("group_info_pkey"), new TableField[] { GroupInfo.GROUP_INFO.CHAT_ID }, true);
    public static final UniqueKey<GroupInfoRecord> UNIQUE_NAME = Internal.createUniqueKey(GroupInfo.GROUP_INFO, DSL.name("unique_name"), new TableField[] { GroupInfo.GROUP_INFO.NAME }, true);
    public static final UniqueKey<PlayerRecord> PLAYER_PKEY = Internal.createUniqueKey(Player.PLAYER, DSL.name("player_pkey"), new TableField[] { Player.PLAYER.ID }, true);
    public static final UniqueKey<RatingRecord> RATING_PKEY = Internal.createUniqueKey(Rating.RATING, DSL.name("rating_pkey"), new TableField[] { Rating.RATING.ID }, true);
    public static final UniqueKey<RatingHistoryRecord> RATING_HISTORY_PKEY = Internal.createUniqueKey(RatingHistory.RATING_HISTORY, DSL.name("rating_history_pkey"), new TableField[] { RatingHistory.RATING_HISTORY.ID }, true);
    public static final UniqueKey<SeasonRecord> SEASON_PKEY = Internal.createUniqueKey(Season.SEASON, DSL.name("season_pkey"), new TableField[] { Season.SEASON.ID }, true);
    public static final UniqueKey<TeamRecord> TEAM_PKEY = Internal.createUniqueKey(Team.TEAM, DSL.name("team_pkey"), new TableField[] { Team.TEAM.ID }, true);
    public static final UniqueKey<TeamPlayerRecord> TEAM_PLAYER_PKEY = Internal.createUniqueKey(TeamPlayer.TEAM_PLAYER, DSL.name("team_player_pkey"), new TableField[] { TeamPlayer.TEAM_PLAYER.ID }, true);
    public static final UniqueKey<UserInfoRecord> USER_INFO_PKEY = Internal.createUniqueKey(UserInfo.USER_INFO, DSL.name("user_info_pkey"), new TableField[] { UserInfo.USER_INFO.TELEGRAM_ID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<EventRecord, GroupInfoRecord> EVENT__FK_EXISTS_CHAT = Internal.createForeignKey(Event.EVENT, DSL.name("fk_exists_chat"), new TableField[] { Event.EVENT.CHAT_ID }, Keys.GROUP_INFO_PKEY, new TableField[] { GroupInfo.GROUP_INFO.CHAT_ID }, true);
    public static final ForeignKey<EventRecord, SeasonRecord> EVENT__FK_EXISTS_SEASON = Internal.createForeignKey(Event.EVENT, DSL.name("fk_exists_season"), new TableField[] { Event.EVENT.SEASON_ID }, Keys.SEASON_PKEY, new TableField[] { Season.SEASON.ID }, true);
    public static final ForeignKey<GameRecord, EventRecord> GAME__FK_EXISTS_EVENT = Internal.createForeignKey(Game.GAME, DSL.name("fk_exists_event"), new TableField[] { Game.GAME.EVENT_ID }, Keys.EVENT_PKEY, new TableField[] { Event.EVENT.ID }, true);
    public static final ForeignKey<PlayerRecord, GroupInfoRecord> PLAYER__FK_EXISTS_CHAT = Internal.createForeignKey(Player.PLAYER, DSL.name("fk_exists_chat"), new TableField[] { Player.PLAYER.CHAT_ID }, Keys.GROUP_INFO_PKEY, new TableField[] { GroupInfo.GROUP_INFO.CHAT_ID }, true);
    public static final ForeignKey<PlayerRecord, UserInfoRecord> PLAYER__FK_EXISTS_USER = Internal.createForeignKey(Player.PLAYER, DSL.name("fk_exists_user"), new TableField[] { Player.PLAYER.USER_ID }, Keys.USER_INFO_PKEY, new TableField[] { UserInfo.USER_INFO.TELEGRAM_ID }, true);
    public static final ForeignKey<RatingRecord, PlayerRecord> RATING__FK_EXISTS_PLAYER = Internal.createForeignKey(Rating.RATING, DSL.name("fk_exists_player"), new TableField[] { Rating.RATING.PLAYER_ID }, Keys.PLAYER_PKEY, new TableField[] { Player.PLAYER.ID }, true);
    public static final ForeignKey<RatingRecord, SeasonRecord> RATING__FK_EXISTS_SEASON = Internal.createForeignKey(Rating.RATING, DSL.name("fk_exists_season"), new TableField[] { Rating.RATING.SEASON_ID }, Keys.SEASON_PKEY, new TableField[] { Season.SEASON.ID }, true);
    public static final ForeignKey<RatingHistoryRecord, GameRecord> RATING_HISTORY__FK_EXISTS_GAME = Internal.createForeignKey(RatingHistory.RATING_HISTORY, DSL.name("fk_exists_game"), new TableField[] { RatingHistory.RATING_HISTORY.GAME_ID }, Keys.GAME_PKEY, new TableField[] { Game.GAME.ID }, true);
    public static final ForeignKey<RatingHistoryRecord, PlayerRecord> RATING_HISTORY__FK_EXISTS_PLAYER = Internal.createForeignKey(RatingHistory.RATING_HISTORY, DSL.name("fk_exists_player"), new TableField[] { RatingHistory.RATING_HISTORY.PLAYER_ID }, Keys.PLAYER_PKEY, new TableField[] { Player.PLAYER.ID }, true);
    public static final ForeignKey<TeamRecord, GameRecord> TEAM__FK_EXISTS_GAME = Internal.createForeignKey(Team.TEAM, DSL.name("fk_exists_game"), new TableField[] { Team.TEAM.GAME_ID }, Keys.GAME_PKEY, new TableField[] { Game.GAME.ID }, true);
    public static final ForeignKey<TeamPlayerRecord, PlayerRecord> TEAM_PLAYER__FK_EXISTS_PLAYER = Internal.createForeignKey(TeamPlayer.TEAM_PLAYER, DSL.name("fk_exists_player"), new TableField[] { TeamPlayer.TEAM_PLAYER.PLAYER_ID }, Keys.PLAYER_PKEY, new TableField[] { Player.PLAYER.ID }, true);
    public static final ForeignKey<TeamPlayerRecord, TeamRecord> TEAM_PLAYER__FK_EXISTS_TEAM = Internal.createForeignKey(TeamPlayer.TEAM_PLAYER, DSL.name("fk_exists_team"), new TableField[] { TeamPlayer.TEAM_PLAYER.TEAM_ID }, Keys.TEAM_PKEY, new TableField[] { Team.TEAM.ID }, true);
}
