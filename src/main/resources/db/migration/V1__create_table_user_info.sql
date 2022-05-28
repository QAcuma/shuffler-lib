create table if not exists user_info
(
    telegram_id     bigint primary key,
    language_code   text,
    is_bot          boolean,
    first_name      text,
    last_name       text,
    user_name       text        not null,
    is_blocked      boolean     not null,
    last_message_at timestamptz,
    created_at      timestamptz not null,
    updated_at      timestamptz,
    deleted_at      timestamptz
);
