package com.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author tangj
 * @date 2018/5/6 22:52
 */
@Configuration
public class NettyClientConfig {
    @Value("${tcp.port}")
    private int tcpPort;

}
