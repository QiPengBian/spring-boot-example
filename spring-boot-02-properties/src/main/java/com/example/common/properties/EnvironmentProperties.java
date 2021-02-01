package com.example.common.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @description: TODO
 * @author: bianqipeng
 * @date: 2021-01-08 16:42:34
 */
@Data
@Component
public class EnvironmentProperties {

    @Value("${env.environment}")
    private String environment;
}
