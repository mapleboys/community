package com.example.communication.controller;

import com.example.communication.dto.PaginationDto;
import com.example.communication.dto.QuestionDto;
import com.example.communication.mapper.QuestionExtMapper;
import com.example.communication.model.Question;
import com.example.communication.service.QuestionDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class QuestionController {
    @Autowired
    QuestionDtoService questionDtoService;

    @Autowired
    QuestionExtMapper questionExtMapper;

    @GetMapping("/question/{id}")
    public String QuestionDetail(@PathVariable(name = "id") Integer id,
                                 Model model) {
        QuestionDto question = questionDtoService.selectById(id);
        model.addAttribute("question", question);
        incViewNum(id);
        return "questionDetail";
    }

    private void incViewNum(Integer id) {
        Question question = new Question();
        question.setId(id);
        questionExtMapper.incView(question);
    }


}
