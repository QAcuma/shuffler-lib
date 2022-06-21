package ru.acuma.shufflerlib.repository;

import ru.acuma.shuffler.tables.pojos.UserInfo;

public interface UserRepository {

    boolean isActive(Long telegramId);

    boolean isBlocked(Long telegramId);

    UserInfo get(Long telegramId);

    long save(UserInfo user);

    long saveProfilePhoto(Long telegramId, byte[] blob);

    long saveProfilePhotoId(Long telegramId, String mediaId);

    long update(UserInfo userInfo);

    void delete(Long userId);

}
