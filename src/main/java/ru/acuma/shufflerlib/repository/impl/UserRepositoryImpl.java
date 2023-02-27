package ru.acuma.shufflerlib.repository.impl;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.acuma.shuffler.tables.daos.UserInfoDao;
import ru.acuma.shuffler.tables.pojos.UserInfo;
import ru.acuma.shufflerlib.repository.UserRepository;

import java.time.OffsetDateTime;
import java.util.List;

import static ru.acuma.shuffler.Tables.USER_INFO;

@Slf4j
@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final DSLContext dsl;

    private UserInfoDao userInfoDao;

    @PostConstruct
    void unitUserInfoDao() {
        userInfoDao = new UserInfoDao(dsl.configuration());
    }

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

    @Override
    public UserInfo get(Long telegramId) {
        return dsl.select()
                .from(USER_INFO)
                .where(USER_INFO.TELEGRAM_ID.eq(telegramId))
                .fetchOneInto(UserInfo.class);
    }

    @Override
    public List<UserInfo> getAll(Boolean... isBlocked) {
        return userInfoDao.fetchByIsBlocked(isBlocked);
    }

    @Override
    public long save(UserInfo userInfo) {
        userInfoDao.insert(userInfo);

        return userInfo.getTelegramId();
    }

    @Override
    public long saveProfilePhoto(Long telegramId, byte[] blob) {
        return dsl.update(USER_INFO)
                .set(USER_INFO.MEDIA_BLOB, blob)
                .where(USER_INFO.TELEGRAM_ID.eq(telegramId))
                .execute();
    }

    @Override
    public long saveProfilePhotoId(Long telegramId, String mediaId) {
        return dsl.update(USER_INFO)
                .set(USER_INFO.MEDIA_ID, mediaId)
                .where(USER_INFO.TELEGRAM_ID.eq(telegramId))
                .execute();
    }

    @Override
    public long update(UserInfo userInfo) {
        userInfoDao.update(userInfo);

        return userInfo.getTelegramId();
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
