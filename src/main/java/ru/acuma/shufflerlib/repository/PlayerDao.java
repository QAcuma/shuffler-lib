package ru.acuma.shufflerlib.repository;

import ru.acuma.shuffler.tables.pojos.Player;

public interface PlayerDao {

    boolean isPresent(Long chatId, Long userId);

    Player get(Long chatId, Long userId);

    long save(Player player);

}
