package com.example.communication.service;

import com.example.communication.dto.CommentDto;
import com.example.communication.enums.CommentTypeEnum;
import com.example.communication.mapper.CommentMapper;
import com.example.communication.mapper.QuestionExtMapper;
import com.example.communication.model.Comment;
import com.example.communication.model.CommentExample;
import com.example.communication.model.Question;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    public List<CommentDto> list(Long id) {
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria().andIdEqualTo(id)
                .andTypeEqualTo(CommentTypeEnum.QUESTION.getType());
        List<Comment> comments = commentMapper.selectByExample(commentExample);
        List<CommentDto> commentDtos = new ArrayList<CommentDto>();
        for (Comment comment : comments) {
            CommentDto commentDto = new CommentDto();
            BeanUtils.copyProperties(comment, commentDto);
        }
        return commentDtos;
    }
}
