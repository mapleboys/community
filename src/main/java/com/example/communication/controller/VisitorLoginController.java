package com.example.communication.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class VisitorLoginController {

    @GetMapping("/login/visitor")
    public String visitorLogin() {

        return "visitorLogin";
    }
}
