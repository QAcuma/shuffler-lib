alter table if exists game
    add column winner_team_id bigint,
    add column loser_team_id  bigint,
    add column discipline     varchar(32),
    drop column winner_id;
