package com.example.communication.controller;

import com.example.communication.dto.PaginationDto;
import com.example.communication.mapper.NotificationMapper;
import com.example.communication.model.Notification;
import com.example.communication.model.NotificationExample;
import com.example.communication.model.User;
import com.example.communication.service.QuestionDtoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
@Slf4j
public class HelloController {
    @Autowired
    QuestionDtoService questionDtoService;
    @Autowired
    NotificationMapper notificationMapper;

    @GetMapping("/")
    public String hello(HttpServletRequest request,
                        @RequestParam(name = "currentPage", defaultValue = "1") Integer currentPage,
                        @RequestParam(name = "offset", defaultValue = "5") Integer offset,
                        @RequestParam(name = "search", required = false) String search,
                        Model model){

        PaginationDto pagination = questionDtoService.list(currentPage, offset, search);
        log.info(pagination.toString());
        model.addAttribute("pagination", pagination);

        // 传入未读通知数
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            NotificationExample notificationExample = new NotificationExample();
            notificationExample.createCriteria().andReceiverEqualTo(user.getId());
            List<Notification> notifications = notificationMapper.selectByExample(notificationExample);
            Long size = notifications.stream().filter(t->t.getStatus()==0).count();
            model.addAttribute("unreadCount", size);
        }
        return "index";
    }
}
