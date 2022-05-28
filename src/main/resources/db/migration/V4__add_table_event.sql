create table if not exists event
(
    id          bigint generated always as identity primary key,
    chat_id     bigint      not null,
    season_id   bigint      not null,
    status      text        not null,
    started_at  timestamptz not null,
    finished_at timestamptz,
    discipline  varchar(32) not null,

    CONSTRAINT fk_exists_chat
        FOREIGN KEY (chat_id)
            REFERENCES group_info(chat_id),

    CONSTRAINT fk_exists_season
        FOREIGN KEY (season_id)
        REFERENCES season (id)
);
