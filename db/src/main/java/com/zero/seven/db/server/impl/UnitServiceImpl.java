package com.zero.seven.db.server.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zero.seven.db.entity.Unit;
import com.zero.seven.db.mapper.UnitMapper;
import com.zero.seven.db.server.UnitService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UnitServiceImpl implements UnitService {
    @Resource
    private UnitMapper unitMapper;

    public void save(Unit unit) {
        unitMapper.insert(unit);
    }

    public Unit getById(int id) {
        return unitMapper.selectById(id);
    }

    public void deleteAll(){

        QueryWrapper<Unit> queryWrapper=new QueryWrapper();
        queryWrapper.eq("age",0);
        List<Unit> list=unitMapper.selectList(queryWrapper);
        List<Integer> ids=new ArrayList<Integer>();
        for(Unit unit:list){
            ids.add(unit.getId());
        }
       unitMapper.deleteBatchIds(ids);
    }

    @Transactional
    public void transactionalTest(Unit unit) {

        unitMapper.insert(unit);
        int i=1/0;
    }
    //@Transactional(propagation = Propagation.REQUIRED)
    public void A() {
        Unit unit=new Unit();
        unit.setName("西瓜");
        unitMapper.insert(unit);
        B();
        //int i=1/0;
    }

   @Transactional(propagation = Propagation.REQUIRED)
    public void B() {
        Unit unit=new Unit();
        unit.setName("南瓜");
        unitMapper.insert(unit);
        int i=1/0;
    }
}
