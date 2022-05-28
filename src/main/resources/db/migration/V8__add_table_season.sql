create table if not exists season
(
    id          bigint generated always as identity primary key,
    started_at  timestamptz,
    finished_at timestamptz
);