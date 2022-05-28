create table if not exists team_player
(
    id bigint generated always as identity primary key,
    player_id bigint,
    team_id bigint,

    CONSTRAINT fk_exists_player
        FOREIGN KEY (player_id)
            REFERENCES player (id),

    CONSTRAINT fk_exists_team
        FOREIGN KEY (team_id)
            REFERENCES team (id)
);


alter table if exists game
    drop column if exists discipline,
    drop column if exists winner_team_id,
    drop column if exists loser_team_id;

alter table if exists event
    drop column messages,
    drop column kickerplayers