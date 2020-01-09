package com.test.spring.mvc.configdemo;

import com.test.spring.mvc.configdemo.interceptor.UserInterceptor;
import com.test.spring.mvc.configdemo.interceptor.UserInterceptor1;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import javax.annotation.Resource;

/**
 * <b>Author</b>: Xiang Liguo<br/>
 * <b>Date</b>: 2020/01/09 13:31<br/>
 * <b>Version</b>: 1.0<br/>
 * <b>Subject</b>: <br/>
 * <b>Description</b>:
 */
@Configuration
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter {

    @Resource
    private UserInterceptor userInterceptor;

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userInterceptor)
                .addPathPatterns("/user/**")
                .excludePathPatterns("/user/query/**");
        registry.addInterceptor(new UserInterceptor1())
                .addPathPatterns("/user/**")
                .excludePathPatterns("");
        super.addInterceptors(registry);
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
        //super.configureViewResolvers(registry);
    }
}
