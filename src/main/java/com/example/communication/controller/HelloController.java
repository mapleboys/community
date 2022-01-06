package com.example.communication.controller;

import com.example.communication.dao.UserDao;
import com.example.communication.dto.PaginationDto;
import com.example.communication.dto.QuestionDto;
import com.example.communication.dto.QuestionQueryDto;
import com.example.communication.model.User;
import com.example.communication.service.QuestionDtoService;
import com.example.communication.util.MybatisUtils;
import javafx.scene.control.Pagination;
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
                        @RequestParam(name = "currentPage", defaultValue = "1") Integer currentPage,
                        @RequestParam(name = "offset", defaultValue = "10") Integer offset,
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

        List<QuestionDto> questionDtos = questionDtoService.list(currentPage, offset);
        System.out.println(questionDtos);
        model.addAttribute("questions", questionDtos);

        // 分页
        PaginationDto paginationDto = new PaginationDto();
//        paginationDto.setQuestionList(questionDtos);
//        paginationDto.setCurrentPage();
//        paginationDto.setPageList();
//        paginationDto.setShowEndPage();
//        paginationDto.setShowFirstPage();
//        paginationDto.setShowNextPage();
//        paginationDto.setShowPreviousPage();

        return "index";
    }
}
