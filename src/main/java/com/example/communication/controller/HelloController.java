package com.example.communication.controller;

import com.example.communication.dao.UserDao;
import com.example.communication.dto.QuestionDto;
import com.example.communication.model.User;
import com.example.communication.service.QuestionDtoService;
import com.example.communication.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class HelloController {
    @GetMapping("/")
    public String hello(HttpServletRequest request,
        Model model){
        Cookie[] cookies = request.getCookies();
        // 判断是否存在token，存在则直接返回用户信息，否则进入登录界面
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if (name.equals("token") ){
                    String token = cookie.getValue();
                    SqlSession sqlSession = MybatisUtils.getSqlseesion();
                    UserDao userdao = sqlSession.getMapper(UserDao.class);
                    User user = userdao.queryUserByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                }
            }
        }

        QuestionDtoService questionDtoService = new QuestionDtoService();
        List<QuestionDto> questionDtos = questionDtoService.list();
        System.out.println(questionDtos);
        model.addAttribute("questions", questionDtos);
        return "index";
    }
}
