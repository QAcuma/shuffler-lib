alter table if exists event
    add column discipline varchar(32),
    add column season_id bigint;

alter table if exists event
    add CONSTRAINT fk_exists_season
        FOREIGN KEY (season_id)
            REFERENCES season (id);