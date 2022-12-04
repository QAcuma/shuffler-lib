package ru.acuma.shufflerlib.repository;

import ru.acuma.shuffler.tables.pojos.UserInfo;

import java.util.List;

public interface UserRepository {

    boolean isActive(Long telegramId);

    boolean isBlocked(Long telegramId);

    UserInfo get(Long telegramId);

    List<UserInfo> getAll(Boolean... isBlocked);

    long save(UserInfo user);

    long saveProfilePhoto(Long telegramId, byte[] blob);

    long saveProfilePhotoId(Long telegramId, String mediaId);

    long update(UserInfo userInfo);

    void delete(Long userId);

}
