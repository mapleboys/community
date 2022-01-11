package com.example.communication.controller;

import com.example.communication.dao.UserDao;
import com.example.communication.dto.PaginationDto;
import com.example.communication.model.User;
import com.example.communication.service.QuestionDtoService;
import com.example.communication.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {
    @Autowired
    QuestionDtoService questionDtoService;

    @GetMapping("/profile/{action}")
    public String profile(@PathVariable(name = "action") String action,
                          @RequestParam(name = "currentPage", defaultValue = "1") Integer currentPage,
                          @RequestParam(name = "offset", defaultValue = "5") Integer offset,
                          HttpServletRequest request,
                          Model model) {

        Cookie[] cookies = request.getCookies();
        User user = new User();
        // 判断是否存在token，存在则直接返回用户信息，否则进入登录界面
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if (name.equals("token") ){
                    String token = cookie.getValue();
                    SqlSession sqlSession = MybatisUtils.getSqlseesion();
                    UserDao userdao = sqlSession.getMapper(UserDao.class);
                    user = userdao.queryUserByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                }
            }
        }

        if(user ==  null) {
            return "redirect:/";
        }
        //根据路径判断需要传入的参数
        if("questions".equals(action)) {
            model.addAttribute("section", "questions");
            model.addAttribute("sectionName", "我的提问");
        } else if ("replies".equals(action)) {
            model.addAttribute("section", "replies");
            model.addAttribute("sectionName", "最新回复");
        }
        // 传入我的提问列表数据
        PaginationDto pagination = questionDtoService.list(user.getId(), currentPage, offset);
        model.addAttribute("pagination");
        model.addAttribute("pagination", pagination);
        return "profile";
    }
}
