package com.example.communication.controller;

import com.example.communication.dto.CommentCreateDto;
import com.example.communication.dto.CommentDto;
import com.example.communication.dto.ResultDto;
import com.example.communication.enums.CommentTypeEnum;
import com.example.communication.exception.CustomizeErrorCode;
import com.example.communication.exception.CustomizeErrorException;
import com.example.communication.mapper.CommentMapper;
import com.example.communication.model.Comment;
import com.example.communication.model.User;
import com.example.communication.service.CommentService;
import com.example.communication.service.NotifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Slf4j
public class CommentController {
    @Autowired
    CommentService commentService;
    @Autowired
    NotifyService notifyService;
    @Autowired
    CommentMapper commentMapper;

    @ResponseBody
    @PostMapping("/comment")
    public Object comment(@RequestBody CommentCreateDto commentDto, HttpServletRequest request) {
        log.info("调用comment接口");
        // 评论功能
        Comment comment = new Comment();
        if (request.getSession().getAttribute("user") == null) {
            throw new CustomizeErrorException(CustomizeErrorCode.UserNotFound);
        }
        User user = (User) request.getSession().getAttribute("user");
        comment.setCommentator(user.getId());
        comment.setContent(commentDto.getContent());
        if (commentDto.getContent() == null || commentDto.getContent().isEmpty()) {
            throw new CustomizeErrorException(CustomizeErrorCode.CommentContentIsEmpty);
        }
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(comment.getGmtCreate());
        comment.setLikeCount(0);
        comment.setCommentCount(0);
        if (commentDto.getParentId() == null) {
            throw new CustomizeErrorException(CustomizeErrorCode.CommentReplyNotFound);
        }
        comment.setParentId(commentDto.getParentId());
        if (commentDto.getType() == null || !CommentTypeEnum.isType(commentDto.getType())) {
            throw new CustomizeErrorException(CustomizeErrorCode.CommentTypeNotFound);
        }
        comment.setType(commentDto.getType());
        commentService.insertComment(comment);

        // 增加评论数记录
        if(commentDto.getType() == 1) {
            commentService.incCommentCount(commentDto.getParentId());
        }

        // 增加通知记录
        notifyService.incNotifyRecord(comment);

        ResultDto resultDto = ResultDto.okOf();
        return resultDto;
    }

    @ResponseBody
    @GetMapping("/comment/{id}")
    public Object commentList(@PathVariable(name = "id") Long id,
                              HttpServletRequest request) {
        log.info("调用comment二级评论接口");
        // 查询评论列表
        List<CommentDto> subCommentDtos = commentService.list(id, CommentTypeEnum.COMMENT);
        log.info("subComentDtos:" + subCommentDtos);
        ResultDto resultDto = ResultDto.okOf(subCommentDtos);
        return resultDto;

    }
}
