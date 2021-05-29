package com.zero.seven.db.config;

import com.zero.seven.db.config.bean.RedisConfigBean;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class RedisConfig {

    @Resource
    private RedisConfigBean redisConfigBean;

    @Bean(destroyMethod = "shutdown")
    public RedissonClient  redisson(){
        Config config = new Config();
        SingleServerConfig singleServerConfig = config.useSingleServer();
        singleServerConfig.setPingConnectionInterval(50000);
        singleServerConfig.setTimeout(5000);
        singleServerConfig.setTcpNoDelay(true);
        singleServerConfig.setKeepAlive(true);
        singleServerConfig.setConnectionPoolSize(128);
        singleServerConfig.setConnectionMinimumIdleSize(32);
        singleServerConfig.setPassword(redisConfigBean.getPassword());
        singleServerConfig.setAddress("redis://" + redisConfigBean.getHost() + ":" + redisConfigBean.getPort());
        return Redisson.create(config);
    }
}
