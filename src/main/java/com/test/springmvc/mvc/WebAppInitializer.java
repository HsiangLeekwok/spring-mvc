package com.test.springmvc.mvc;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * <b>Author</b>: Xiang Liguo<br/>
 * <b>Date</b>: 2020/01/07 13:56<br/>
 * <b>Version</b>: 1.0<br/>
 * <b>Subject</b>: <br/>
 * <b>Description</b>:
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // 父容器
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{SpringContainer.class};
    }

    // SpringMVC配置子容器
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{MvcContainer.class};
    }

    // 获取 DispatcherServlet 的映射信息
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        return super.getServletFilters();
    }
}
