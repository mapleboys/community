package com.example.communication.mapper;

import com.example.communication.dto.QuestionQueryDto;
import com.example.communication.model.Question;

import java.util.List;

public interface QuestionExtMapper {
    int incView(Question record);
    int incComment(Question record);
    List<Question> queryRelativeQuestion(Question record);
    List<Question> queryBySearch(QuestionQueryDto questionQueryDto);
    int countBySearch(QuestionQueryDto questionQueryDto);
}