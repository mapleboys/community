package com.example.communication.controller;

import com.example.communication.enums.NotifyStatusEnum;
import com.example.communication.mapper.NotificationMapper;
import com.example.communication.model.Notification;
import com.example.communication.model.NotificationExample;
import com.example.communication.model.User;
import com.example.communication.service.NotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;

@Controller
public class NotificationController {
    @Autowired
    NotificationMapper notificationMapper;
    @Autowired
    NotifyService notifyService;

    @GetMapping("/notification/{id}")
    public String notification(@PathVariable("id") Long id,
                               HttpServletRequest request) {

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }
        Long questionId = notifyService.read(id);

        return "redirect:/question/" + questionId;
    }
}
