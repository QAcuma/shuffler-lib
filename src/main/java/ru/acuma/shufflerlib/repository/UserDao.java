package ru.acuma.shufflerlib.repository;

import ru.acuma.shuffler.tables.pojos.UserInfo;

public interface UserDao {

    boolean isActive(Long telegramId);

    boolean isBlocked(Long telegramId);

    UserInfo get(Long telegramId);

    long save(UserInfo user);

    void delete(Long userId);

}
