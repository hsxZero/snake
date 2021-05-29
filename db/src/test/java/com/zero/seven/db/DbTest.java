package com.zero.seven.db;

import com.zero.seven.db.entity.Unit;
import com.zero.seven.db.server.impl.TransactionalA;
import com.zero.seven.db.server.impl.TransactionalB;
import com.zero.seven.db.server.impl.TransactionalC;
import com.zero.seven.db.server.impl.UnitServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DbTest {
    @Resource
    private UnitServiceImpl unitService;

    @Resource
    private TransactionalA transactionalA;

    @Resource
    private TransactionalB transactionalB;


     @Test
    public void test(){
         Unit unit=new Unit();
         unit.setName("西瓜");
       unitService.transactionalTest(unit);
    }

    @Test
    public void test1(){
         unitService.deleteAll();
    }

    @Test
    public void test2(){
        transactionalA.A();
    }
    @Test
    public void test3(){
        TransactionalC transactionalC=new TransactionalC();
        transactionalC.C();
    }

    @Test
    public void test4(){
        //transactionalA.A();
        transactionalB.B();
    }
}
