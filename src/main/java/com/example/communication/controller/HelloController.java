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
import java.time.LocalDateTime;
import java.util.List;


@Controller
public class HelloController {
    @Autowired
    QuestionDtoService questionDtoService;

    @GetMapping("/")
    public String hello(HttpServletRequest request,
                        @RequestParam(name = "currentPage", defaultValue = "1") Integer currentPage,
                        @RequestParam(name = "offset", defaultValue = "5") Integer offset,
                        Model model){

        PaginationDto pagination = questionDtoService.list(currentPage, offset);
        System.out.println(pagination);
        model.addAttribute("pagination", pagination);
        return "index";
    }
}
