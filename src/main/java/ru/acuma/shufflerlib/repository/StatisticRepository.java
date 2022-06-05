package ru.acuma.shufflerlib.repository;

import ru.acuma.shufflerlib.model.Filter;
import ru.acuma.shufflerlib.model.StatisticResult;

import java.util.List;

public interface StatisticRepository {

    List<StatisticResult> findAllByFilter(Filter filter);

}
