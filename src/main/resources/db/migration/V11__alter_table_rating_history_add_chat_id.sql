alter table if exists rating_history
    add column if not exists chat_id bigint,
    alter column chat_id set not null,

    add CONSTRAINT fk_exists_chat
        FOREIGN KEY (chat_id)
            REFERENCES group_info (chat_id);