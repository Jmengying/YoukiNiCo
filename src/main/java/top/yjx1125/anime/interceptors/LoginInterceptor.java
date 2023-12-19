package top.yjx1125.anime.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import top.yjx1125.anime.pojo.Result;
import top.yjx1125.anime.utils.JwtUtil;
import top.yjx1125.anime.utils.ThreadLocalUtil;

import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //令牌验证;
        String token = request.getHeader("Authorization");
        try{
            Map<String,Object> claims = JwtUtil.parseToken(token);
            //把数据存储到ThreadLocal
            ThreadLocalUtil.set(claims);

            return true;//放行
        }catch (Exception e){
            response.setStatus(401);
            return false;//不放行
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ThreadLocalUtil.remove();//清空数据,防止内存泄漏
    }
}
