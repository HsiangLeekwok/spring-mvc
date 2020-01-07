package com.test.springmvc.tomcat.servletdemo;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.Set;

/**
 * <b>Author</b>: Xiang Liguo<br/>
 * <b>Date</b>: 2020/01/07 09:28<br/>
 * <b>Version</b>: 1.0<br/>
 * <b>Subject</b>: 自动加载 Servlet <br/>
 * <b>Description</b>:
 */
@HandlesTypes(value = {LoadService.class})
public class CustomServletContainerInitializer implements ServletContainerInitializer {

    /**
     * SPI 设计模式
     * tomcat启动之后会加载此方法，在此方法中找到所有实现了 @HandlesTypes 里指定的类的实例并进行初始化
     *
     * @param set            所有实现了 @HandlesTypes 中指定接口的类的集合
     * @param servletContext 当前 Servlet 的上下文对象
     */
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        Iterator<Class<?>> iterator;
        if (null != set) {
            iterator = set.iterator();
            while (iterator.hasNext()) {
                Class<?> clazz = iterator.next();
                if (!clazz.isInterface() && !Modifier.isAbstract(clazz.getModifiers()) && LoadService.class.isAssignableFrom(clazz)) {
                    try {
                        // 初始化对象并调用接口方法以实现自定义的加载内容
                        LoadService service = (LoadService) clazz.newInstance();
                        service.loadOnStartup(servletContext);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
