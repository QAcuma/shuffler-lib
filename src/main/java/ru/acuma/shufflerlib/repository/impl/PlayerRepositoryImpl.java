package ru.acuma.shufflerlib.repository.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.acuma.shuffler.tables.pojos.Player;
import ru.acuma.shuffler.tables.records.PlayerRecord;
import ru.acuma.shufflerlib.repository.PlayerRepository;

import static ru.acuma.shuffler.tables.Player.PLAYER;

@Repository
@RequiredArgsConstructor
public class PlayerRepositoryImpl implements PlayerRepository {

    private final DSLContext dsl;

    @Override
    public boolean isPresent(Long chatId, Long userId) {
        return dsl.fetchExists(
                dsl.selectFrom(PLAYER)
                        .where(PLAYER.CHAT_ID.eq(chatId))
                        .and(PLAYER.USER_ID.eq(userId))
        );
    }

    @Override
    public Player get(Long chatId, Long userId) {
        return dsl.select()
                .from(PLAYER)
                .where(PLAYER.CHAT_ID.eq(chatId))
                .and(PLAYER.USER_ID.eq(userId))
                .fetchOneInto(Player.class);
    }

    @Override
    public long save(Player player) {
        PlayerRecord record = dsl.newRecord(PLAYER, player);
        record.store();
        return record.getId();
    }

}
