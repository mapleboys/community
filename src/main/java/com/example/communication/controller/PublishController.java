package com.example.communication.controller;


import com.example.communication.dto.QuestionDto;
import com.example.communication.model.Question;
import com.example.communication.model.User;
import com.example.communication.service.QuestionDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @Autowired
    QuestionDtoService questionDtoService;

    @PostMapping ("/doPublish")
    public String doPublish(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "tag", required = false) String tag,
            @RequestParam(value = "id", required = false) Long id,
            HttpServletRequest request,
            Model model) {

        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("tag", tag);

        //判断是否有值
        if (title == null || title.length() == 0) {
            model.addAttribute("error", "标题不能为空");
            return "publish";
        }
        if (description == null || description.length() == 0) {
            model.addAttribute("error", "问题补充不能为空");
            return "publish";
        }
        if (tag == null || tag.length() == 0) {
            model.addAttribute("error", "标签不能为空");
            return "publish";
        }


        System.out.println("调用pulish的post请求");

        User user = (User) request.getSession().getAttribute("user");
        // 返回错误信息
        if (user == null) {
            model.addAttribute("error", "用户未登录");
            return "publish";
        }
        System.out.println("开始插入数据");
        // 插入question数据
        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setCommentAccount(0);
        question.setLikeAccount(0);
        question.setViewAccount(0);
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(question.getGmtCreate());
        question.setId(id);

        questionDtoService.createOrUpdate(question);
        return "redirect:/";
    }

    @GetMapping("/publish/{id}")
    public String publishUpdate(@PathVariable(value = "id") Long id,
                                Model model) {
        QuestionDto questionDto = questionDtoService.selectById(id);
        model.addAttribute("title", questionDto.getTitle());
        model.addAttribute("description", questionDto.getDescription());
        model.addAttribute("tag", questionDto.getTag());
        model.addAttribute("id", id);
        return "publish";
    }
}
