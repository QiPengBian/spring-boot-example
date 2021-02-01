package com.example.sys.controller;

import com.example.common.properties.DeveloperProperties;
import com.example.common.properties.EnvironmentProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: TODO
 * @author: bianqipeng
 * @date: 2021-01-08 16:48:11
 */
@RestController
@RequestMapping("sys/environment")
public class EnvironmentController {

    @Autowired
    private EnvironmentProperties environmentProperties;

    @Autowired
    private DeveloperProperties developerProperties;

    /**
     * @description: TODO
     * @author: bianqipeng
     * @date: 2021-01-08 16:51:43
     * @return: Map<String, Object>
     */
    @GetMapping("/queryEnvironment")
    public Map<String, Object> queryEnvironment() {
        Map<String, Object> map = new HashMap<>(16);
        map.put("environment", environmentProperties);
        map.put("developer", developerProperties);
        return map;
    }
}
