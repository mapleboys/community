package com.example.communication.service;

import com.example.communication.dto.CommentDto;
import com.example.communication.enums.CommentTypeEnum;
import com.example.communication.mapper.CommentExtMapper;
import com.example.communication.mapper.CommentMapper;
import com.example.communication.mapper.QuestionExtMapper;
import com.example.communication.mapper.UserMapper;
import com.example.communication.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Autowired
    QuestionExtMapper questionExtMapper;

    @Autowired
    CommentExtMapper commentExtMapper;

    @Autowired
    UserMapper userMapper;

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

    public List<CommentDto> list(Long id, CommentTypeEnum commentTypeEnum) {
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria().andParentIdEqualTo(id)
                .andTypeEqualTo(commentTypeEnum.getType());
        List<Comment> comments = commentMapper.selectByExample(commentExample);
        List<CommentDto> commentDtos = new ArrayList<CommentDto>();
        UserExample userExample = new UserExample();
        List<User> users = userMapper.selectByExample(userExample);
        Map<Long, User> userMap = users.stream().collect(Collectors.toMap(User::getId, (b) -> b));
        for (Comment comment : comments) {
            CommentDto commentDto = new CommentDto();
            BeanUtils.copyProperties(comment, commentDto);
            commentDto.setUser(userMap.get(comment.getCommentator()));
            commentDtos.add(commentDto);
        }
        return commentDtos;
    }

    public void incCommentCount(Long parentId) {
        Comment comment = new Comment();
        comment.setId(parentId);
        comment.setCommentCount(1);
        commentExtMapper.incComment(comment);
    }
}
