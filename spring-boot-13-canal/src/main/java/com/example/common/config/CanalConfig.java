package com.example.common.config;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;

/**
 * @description: canal配置
 * @author: bianqipeng
        * @date: 2021-07-08 11:39:28
        */
@Configuration
public class CanalConfig {

    private static final String CANAL_SERVER_HOST = "192.168.11.130";
    private static final int CANAL_SERVER_PORT = 11111;
    private static final String CANAL_DESTINATION = "cluster";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";

    /**
     * @description: 注入canal连接
     * @author: bianqipeng
     * @date: 2021-07-13 11:27:52
     * @return: CanalConnector
     */
    @Bean
    public CanalConnector canalSimpleConnector() {
        CanalConnector canalConnector = CanalConnectors.newSingleConnector(new InetSocketAddress(CANAL_SERVER_HOST, CANAL_SERVER_PORT), CANAL_DESTINATION, USERNAME, PASSWORD);
        canalConnector.connect();
        return canalConnector;
    }
}
