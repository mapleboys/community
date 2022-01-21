package com.example.communication.controller;

import com.example.communication.dto.CommentDto;
import com.example.communication.dto.QuestionDto;
import com.example.communication.enums.CommentTypeEnum;
import com.example.communication.exception.CustomizeErrorCode;
import com.example.communication.exception.CustomizeErrorException;
import com.example.communication.mapper.QuestionExtMapper;
import com.example.communication.model.Question;
import com.example.communication.service.CommentService;
import com.example.communication.service.QuestionDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class QuestionController {
    @Autowired
    QuestionDtoService questionDtoService;

    @Autowired
    QuestionExtMapper questionExtMapper;

    @Autowired
    CommentService commentService;

    @GetMapping("/question/{id}")
    public String QuestionDetail(@PathVariable(name = "id") Long id,
                                 Model model) {
        QuestionDto question = questionDtoService.selectById(id);
        if (question == null) {
            throw new CustomizeErrorException(CustomizeErrorCode.QuestionNotFound);
        }
        model.addAttribute("question", question);
        incViewNum(id);
        // 查询评论列表
        List<CommentDto> commentDtos = commentService.list(id, CommentTypeEnum.QUESTION);
        System.out.println("comentDtos:" + commentDtos);
        model.addAttribute("comments", commentDtos);
        // 查询相关问题
        List<Question> relatedQuestions = questionDtoService.queryRelativeQuestion(id);
        model.addAttribute("RelatedQuestions", relatedQuestions);
        return "questionDetail";
    }
    private void incViewNum(Long id) {
        Question question = new Question();
        question.setId(id);
        question.setViewAccount(1);
        questionExtMapper.incView(question);
    }
}
