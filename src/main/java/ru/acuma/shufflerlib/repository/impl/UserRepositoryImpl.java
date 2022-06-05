package ru.acuma.shufflerlib.repository.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.acuma.shuffler.tables.pojos.UserInfo;
import ru.acuma.shuffler.tables.records.UserInfoRecord;
import ru.acuma.shufflerlib.repository.UserRepository;

import java.time.OffsetDateTime;

import static ru.acuma.shuffler.Tables.USER_INFO;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final DSLContext dsl;

    @Override
    public boolean isBlocked(Long telegramId) {
        return dsl.fetchExists(
                dsl.selectFrom(USER_INFO)
                        .where(USER_INFO.TELEGRAM_ID.eq(telegramId))
                        .and(USER_INFO.IS_BLOCKED.eq(Boolean.TRUE))
        );
    }

    @Override
    public boolean isActive(Long telegramId) {
        return dsl.fetchExists(
                dsl.selectFrom(USER_INFO)
                        .where(USER_INFO.TELEGRAM_ID.eq(telegramId))
                        .and(USER_INFO.IS_BLOCKED.eq(Boolean.FALSE))
                        .and(USER_INFO.DELETED_AT.isNull())
        );
    }

    @SneakyThrows
    @Override
    public UserInfo get(Long telegramId) {
        return dsl.select()
                .from(USER_INFO)
                .where(USER_INFO.TELEGRAM_ID.eq(telegramId))
                .fetchOneInto(UserInfo.class);
    }

    @Override
    public long save(UserInfo userInfo) {
        UserInfoRecord record = dsl.newRecord(USER_INFO, userInfo);
        record.store();
        return record.getTelegramId();
    }

    @Override
    public void delete(Long telegramId) {
        dsl.update(USER_INFO)
                .set(USER_INFO.DELETED_AT, OffsetDateTime.now())
                .set(USER_INFO.IS_BLOCKED, true)
                .where(USER_INFO.TELEGRAM_ID.eq(telegramId))
                .execute();
    }
}