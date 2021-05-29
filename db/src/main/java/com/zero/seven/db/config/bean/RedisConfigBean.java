package com.zero.seven.db.config.bean;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ConfigurationProperties(prefix = "redis")
@Component
public class RedisConfigBean {

    private String host;
    private String password;
    private String port;
}
