package com.example.communication.service;

import com.example.communication.enums.CommentTypeEnum;
import com.example.communication.mapper.CommentMapper;
import com.example.communication.mapper.QuestionExtMapper;
import com.example.communication.mapper.QuestionMapper;
import com.example.communication.model.Comment;
import com.example.communication.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Autowired
    QuestionExtMapper questionExtMapper;

    @Transactional
    public void insertComment(Comment comment) {
        commentMapper.insertSelective(comment);
        // 问题评论则增加评论数
        if (0 == comment.getType()) {
            Question record = new Question();
            record.setId(comment.getParentId());
            record.setCommentAccount(1);
            questionExtMapper.incComment(record);
        }

    }
}
