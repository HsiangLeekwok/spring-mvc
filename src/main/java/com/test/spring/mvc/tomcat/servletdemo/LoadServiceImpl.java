package com.test.spring.mvc.tomcat.servletdemo;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

/**
 * <b>Author</b>: Xiang Liguo<br/>
 * <b>Date</b>: 2020/01/07 09:59<br/>
 * <b>Version</b>: 1.0<br/>
 * <b>Subject</b>: 实现了自定义 LoadService 接口的类<br/>
 * <b>Description</b>: tomcat 启动之后会自动加载到这个类的 loadOnStartup 方法，在这里可以做自定义的初始化
 */
public class LoadServiceImpl implements LoadService {

    public void loadOnStartup(ServletContext servletContext) {
        ServletRegistration.Dynamic initServlet = servletContext.addServlet("initServlet", "com.test.spring.mvc.tomcat.servletdemo.servlets.InitServlet");
        // 指定在 tomcat 启动时即加载，大于等于0的话。
        initServlet.setLoadOnStartup(1);
        // 设置拦截的路径
        initServlet.addMapping("/init");
    }
}
