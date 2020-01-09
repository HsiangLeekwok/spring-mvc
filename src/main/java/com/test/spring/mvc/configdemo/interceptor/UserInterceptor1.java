package com.test.spring.mvc.configdemo.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <b>Author</b>: Xiang Liguo<br/>
 * <b>Date</b>: 2020/01/09 13:35<br/>
 * <b>Version</b>: 1.0<br/>
 * <b>Subject</b>: <br/>
 * <b>Description</b>:
 */
@Component
public class UserInterceptor1 implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("===> UserInterceptor1 用户权限校验 <===");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("===> UserInterceptor1 修改 model 和 view <===");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("===> UserInterceptor1 资源释放 <===");
    }
}
