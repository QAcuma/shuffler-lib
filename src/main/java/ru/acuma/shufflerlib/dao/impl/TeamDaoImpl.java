package ru.acuma.shufflerlib.dao.impl;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import ru.acuma.shufflerlib.dao.TeamDao;

@Repository
@RequiredArgsConstructor
public class TeamDaoImpl implements TeamDao {

    private final DSLContext dsl;
}
