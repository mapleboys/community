package com.example.communication.controller;

import com.example.communication.dto.PaginationDto;
import com.example.communication.mapper.NotificationMapper;
import com.example.communication.model.Notification;
import com.example.communication.model.NotificationExample;
import com.example.communication.model.User;
import com.example.communication.service.NotifyService;
import com.example.communication.service.QuestionDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ProfileController {
    @Autowired
    QuestionDtoService questionDtoService;
    @Autowired
    NotificationMapper notificationMapper;
    @Autowired
    NotifyService notifyService;

    @GetMapping("/profile/{action}")
    public String profile(@PathVariable(name = "action") String action,
                          @RequestParam(name = "currentPage", defaultValue = "1") Integer currentPage,
                          @RequestParam(name = "offset", defaultValue = "5") Integer offset,
                          HttpServletRequest request,
                          Model model) {

        User user = (User) request.getSession().getAttribute("user");
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
        // 传入通知列表数据、未读数据
        NotificationExample notificationExample = new NotificationExample();
        notificationExample.createCriteria().andReceiverEqualTo(user.getId());
        List<Notification> notifications = notificationMapper.selectByExample(notificationExample);
        int size = notifications.size();
        model.addAttribute("unreadCount", size);
        model.addAttribute("notifications", notifications);

        return "profile";
    }


}
