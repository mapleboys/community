package com.example.communication.interceptor;

import com.example.communication.mapper.UserMapper;
import com.example.communication.model.User;
import com.example.communication.model.UserExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
@Slf4j
public class SessionInterceptor implements HandlerInterceptor {
    @Autowired(required = false)
    UserMapper userMapper;
    @Value("${github.redirect.uri}")
    private String githubRedirectUri;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.getServletContext().setAttribute("githubRedirectUri", githubRedirectUri);
        Cookie[] cookies = request.getCookies();
        log.info("判断000");
        // 判断是否存在token，存在则直接返回用户信息，否则进入登录界面
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if (name.equals("token") ){
                    String token = cookie.getValue();
                    UserExample usersExample = new UserExample();
                    usersExample.createCriteria().andTokenEqualTo(token);
                    List<User> users = userMapper.selectByExample(usersExample);
                    if (users != null && users.size() != 0) {
                        request.getSession().setAttribute("user", users.get(0));
                    }
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
