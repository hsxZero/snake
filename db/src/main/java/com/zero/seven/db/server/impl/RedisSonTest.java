package com.zero.seven.db.server.impl;


import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RedisSonTest {

    @Resource
    private RedissonClient redisson;

    public void test(){
    }
}
