package com.oak.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "image")
public class ImageProperties {

    // 图片存放位置
    private String directory;

    // 前缀
    private String prefix;

    // 图片类型
    private List<String> types;
}
