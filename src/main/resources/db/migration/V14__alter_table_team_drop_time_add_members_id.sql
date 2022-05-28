alter table if exists team
    drop column started_at,
    drop column finished_at,
    add column winner boolean;