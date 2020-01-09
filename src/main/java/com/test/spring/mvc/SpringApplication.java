package com.test.spring.mvc;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

/**
 * <b>Author</b>: 小果<br/>
 * <b>Date</b>: 2020/01/07 13:37<br/>
 * <b>Version</b>: 1.0<br/>
 * <b>Subject</b>: <br/>
 * <b>Description</b>:
 */
public class SpringApplication {

    public static void main(String[] args) {
        run(SpringApplication.class, args);
    }

    private static void run(Object source, String... args) {
        try {
            // 创建 tomcat 容器
            Tomcat tomcat = new Tomcat();
            // 设置端口号
            tomcat.setPort(9099);
            // 读取项目路径，加载静态资源
            StandardContext sc = (StandardContext) tomcat.addWebapp("/",
                    new File("src/main").getAbsolutePath());
            // 禁止重新载入
            sc.setReloadable(false);
            // class 文件读取地址
            File additionWebInfClasses = new File("target/classes");
            // 创建 WebRoot
            WebResourceRoot resource = new StandardRoot(sc);
            // tomcat 内部读取 class 执行
            resource.addPreResources(new DirResourceSet(resource, "/WEB-INF/classes",
                    additionWebInfClasses.getAbsolutePath(), "/"));
            // 启动 tomcat
            tomcat.start();
            // 异步等待请求执行
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}

