package com.test.spring.mvc.tomcat.servletdemo;

import javax.servlet.ServletContext;

/**
 * <b>Author</b>: Xiang Liguo<br/>
 * <b>Date</b>: 2020/01/07 09:50<br/>
 * <b>Version</b>: 1.0<br/>
 * <b>Subject</b>: <br/>
 * <b>Description</b>:
 */
public interface LoadService {
    void loadOnStartup(ServletContext servletContext);
}
