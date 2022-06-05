package ru.acuma.shufflerlib.repository;

import ru.acuma.shuffler.tables.pojos.GroupInfo;

public interface GroupRepository {

    long save(GroupInfo groupInfo);

    boolean isActive(Long chatId);

}
