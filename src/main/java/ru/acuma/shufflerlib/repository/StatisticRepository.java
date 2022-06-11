package ru.acuma.shufflerlib.repository;

import ru.acuma.shufflerlib.model.Filter;
import ru.acuma.shufflerlib.model.web.entity.WebPlayer;

import java.util.List;

public interface StatisticRepository {

    List<WebPlayer> findAllByFilter(Filter filter);

}
