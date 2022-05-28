alter table if exists event
    add column index bigint;

alter table if exists game
    drop column if exists season_id;

alter table if exists player
    drop column if exists first_player_id,
    drop column if exists second_player_id;