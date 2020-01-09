package com.test.spring.mvc.initializerdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * <b>Author</b>: Xiang Liguo<br/>
 * <b>Date</b>: 2020/01/07 15:02<br/>
 * <b>Version</b>: 1.0<br/>
 * <b>Subject</b>: 自定义的 Spring 容器配置类<br/>
 * <b>Description</b>:
 */
@ComponentScan(value = "com.test.spring.mvc", excludeFilters = {
        // 设置不扫描带有 @Controller 注解的类
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
})
public class SpringContainer {
}
