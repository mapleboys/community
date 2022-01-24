package com.example.communication.controller;

import com.example.communication.dto.PaginationDto;
import com.example.communication.service.QuestionDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


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
        // 未读通知数
        model.addAttribute("unreadCount", 12);
        return "index";
    }
}
