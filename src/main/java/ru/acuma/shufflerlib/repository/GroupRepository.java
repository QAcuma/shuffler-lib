package ru.acuma.shufflerlib.repository;

import ru.acuma.shuffler.tables.pojos.GroupInfo;

import java.util.List;

public interface GroupRepository {

    long save(GroupInfo groupInfo);

    boolean isActive(Long chatId);

    List<GroupInfo> findActiveGroups(Long seasonId);
}
