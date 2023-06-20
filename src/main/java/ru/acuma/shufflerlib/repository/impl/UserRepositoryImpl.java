package ru.acuma.shufflerlib.repository.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.acuma.shuffler.tables.daos.UserInfoDao;
import ru.acuma.shuffler.tables.pojos.UserInfo;
import ru.acuma.shufflerlib.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.time.OffsetDateTime;

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
                        .where(USER_INFO.ID.eq(telegramId))
                        .and(USER_INFO.IS_ACTIVE.eq(Boolean.FALSE))
        );
    }

    @Override
    public boolean isActive(Long telegramId) {
        return dsl.fetchExists(
                dsl.selectFrom(USER_INFO)
                        .where(USER_INFO.ID.eq(telegramId))
                        .and(USER_INFO.IS_ACTIVE.eq(Boolean.TRUE))
                        .and(USER_INFO.DELETED_AT.isNull())
        );
    }

    @SneakyThrows
    @Override
    public UserInfo get(Long telegramId) {
        return dsl.select()
                .from(USER_INFO)
                .where(USER_INFO.ID.eq(telegramId))
                .fetchOneInto(UserInfo.class);
    }

    @Override
    public long save(UserInfo userInfo) {
        userInfoDao.insert(userInfo);

        return userInfo.getId();
    }

    @Override
    public long saveProfilePhotoId(Long telegramId, String mediaId) {
        return dsl.update(USER_INFO)
                .set(USER_INFO.MEDIA_ID, mediaId)
                .where(USER_INFO.ID.eq(telegramId))
                .execute();
    }

    @Override
    public long update(UserInfo userInfo) {
        userInfoDao.update(userInfo);

        return userInfo.getId();
    }

    @Override
    public void delete(Long telegramId) {
        dsl.update(USER_INFO)
                .set(USER_INFO.DELETED_AT, OffsetDateTime.now())
                .set(USER_INFO.IS_ACTIVE, false)
                .where(USER_INFO.ID.eq(telegramId))
                .execute();
    }
}
