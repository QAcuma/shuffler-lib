package ru.acuma.shufflerlib.repository.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.acuma.shuffler.tables.pojos.GroupInfo;
import ru.acuma.shuffler.tables.records.GroupInfoRecord;
import ru.acuma.shufflerlib.repository.GroupRepository;

import java.util.List;

import static ru.acuma.shuffler.Tables.EVENT;
import static ru.acuma.shuffler.Tables.GROUP_INFO;

@Repository
@RequiredArgsConstructor
public class GroupRepositoryImpl implements GroupRepository {

    private final DSLContext dsl;

    @Override
    public long save(GroupInfo groupInfo) {
        GroupInfoRecord record = dsl.newRecord(GROUP_INFO, groupInfo);
        return record.store();
    }

    @Override
    public boolean isActive(Long chatId) {
        return dsl.fetchExists(
                dsl.selectFrom(GROUP_INFO)
                        .where(GROUP_INFO.CHAT_ID.eq(chatId))
                        .and(GROUP_INFO.IS_BLOCKED.eq(Boolean.FALSE))
        );
    }

    @Override
    public List<GroupInfo> findActiveGroups(Long seasonId) {
        return dsl.selectDistinct(GROUP_INFO.fields())
                .from(EVENT)
                .join(GROUP_INFO).on(GROUP_INFO.CHAT_ID.eq(EVENT.CHAT_ID))
                .where(EVENT.SEASON_ID.eq(seasonId))
                .and(EVENT.STATE.eq("FINISHED"))
                .fetchInto(GroupInfo.class);
    }

}
