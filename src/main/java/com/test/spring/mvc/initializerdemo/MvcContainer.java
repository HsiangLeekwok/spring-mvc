package com.test.spring.mvc.initializerdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * <b>Author</b>: Xiang Liguo<br/>
 * <b>Date</b>: 2020/01/07 15:02<br/>
 * <b>Version</b>: 1.0<br/>
 * <b>Subject</b>: <br/>
 * <b>Description</b>:
 */
@ComponentScan(value = "com.test.spring.mvc", includeFilters = {
        // 设置只扫描指定包下带有的 @Controller 注解的类
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {Controller.class})
})
public class MvcContainer {
}
