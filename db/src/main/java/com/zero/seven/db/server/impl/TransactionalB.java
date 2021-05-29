package com.zero.seven.db.server.impl;

import com.zero.seven.db.entity.Unit;
import com.zero.seven.db.mapper.UnitMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class TransactionalB {

    @Resource
    private UnitMapper unitMapper;



  //  @Transactional(propagation = Propagation.REQUIRED)
    public void B() {
        Unit unit=new Unit();
        unit.setName("南瓜");
        unitMapper.insert(unit);
        //int i=1/0;
    }
}
