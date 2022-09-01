package ru.acuma.shufflerlib.repository;

import ru.acuma.shufflerlib.model.Filter;
import ru.acuma.shufflerlib.model.web.entity.WebGraph;

public interface StatisticRepository {

    WebGraph buildGraphData(Filter filter);

}
