package ru.acuma.shufflerlib.repository;

import ru.acuma.shuffler.tables.pojos.Player;
import ru.acuma.shufflerlib.model.Filter;
import ru.acuma.shufflerlib.model.web.entity.WebPlayer;
import ru.acuma.shufflerlib.model.web.entity.WebPlayerDetails;

import java.util.List;

public interface PlayerRepository {

    boolean isPresent(Long chatId, Long userId);

    Player get(Long chatId, Long userId);

    long save(Player player);

    long update(Player player);

    WebPlayerDetails findPlayerInfo(Filter filter);

    List<WebPlayer> buildLadderData(Filter filter);

    List<Long> findActivePlayers(Filter filter);
}
