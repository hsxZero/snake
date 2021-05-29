package com.zero.seven.db.server;

import com.zero.seven.db.entity.Unit;

public interface UnitService {

    void save(Unit unit);

    Unit getById(int id);
}
