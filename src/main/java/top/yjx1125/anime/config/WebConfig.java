package top.yjx1125.anime.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.yjx1125.anime.interceptors.LoginInterceptor;

@Configuration//拦截器
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //登录注册不拦截

        registry.addInterceptor(loginInterceptor).excludePathPatterns("/user/login","/user/register");
    }
}
