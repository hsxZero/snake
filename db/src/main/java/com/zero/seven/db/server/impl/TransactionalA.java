package com.zero.seven.db.server.impl;

import com.zero.seven.db.entity.Unit;
import com.zero.seven.db.mapper.UnitMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class TransactionalA {

    @Resource
    private UnitMapper unitMapper;

    @Resource
    private TransactionalB transactionalB;

    //@Transactional(propagation = Propagation.REQUIRED)
    public void A() {
        Unit unit=new Unit();
        unit.setName("西瓜");
        unitMapper.insert(unit);
        transactionalB.B();
    }


}
