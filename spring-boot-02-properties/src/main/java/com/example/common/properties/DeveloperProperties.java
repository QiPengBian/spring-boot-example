package com.example.common.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description: TODO
 * @author: bianqipeng
 * @date: 2021-01-08 16:43:16
 */
@Data
@Component
@ConfigurationProperties(prefix = "developer")
public class DeveloperProperties {

    private String author;

    private String email;
}
