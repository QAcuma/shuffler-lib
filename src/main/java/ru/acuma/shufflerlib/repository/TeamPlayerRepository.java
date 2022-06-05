package ru.acuma.shufflerlib.repository;

import ru.acuma.shuffler.tables.pojos.TeamPlayer;

public interface TeamPlayerRepository {

    long save(TeamPlayer teamPlayer);

}
