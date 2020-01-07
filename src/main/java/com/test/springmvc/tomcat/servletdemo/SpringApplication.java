package com.test.springmvc.tomcat.servletdemo;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

/**
 * <b>Author</b>: Xiang Liguo<br/>
 * <b>Date</b>: 2020/01/07 13:37<br/>
 * <b>Version</b>: 1.0<br/>
 * <b>Subject</b>: <br/>
 * <b>Description</b>:
 */
public class SpringApplication {
    public static void main(String[] args) {
        run(null, args);
    }

    private static void run(Object source, String... args) {
        try {
            // 创建 tomcat 容器
            Tomcat tomcat = new Tomcat();
            // 设置端口号
            tomcat.setPort(9090);
            // 读取项目路径，加载静态资源
            StandardContext sc = (StandardContext) tomcat.addContext(null, null);
            // 禁止重新载入
            sc.setReloadable(false);
            // class 文件读取地址
            File additionWebInfClasses = new File("spring");
            // 创建 WebRoot
            WebResourceRoot resource = new StandardRoot(sc);
            // tomcat 内部读取 class 执行
            resource.addPreResources(new DirResourceSet(resource, "", "", ""));
            // 启动 tomcat
            tomcat.start();
            // 异步等待请求执行
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}

