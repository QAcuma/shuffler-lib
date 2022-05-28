alter table if exists player
    add column discipline       varchar(32),
    add column season_id        bigint,
    add column first_player_id  bigint,
    add column second_player_id bigint;

alter table if exists player
    add CONSTRAINT fk_exists_season
        FOREIGN KEY (season_id)
            REFERENCES season (id);