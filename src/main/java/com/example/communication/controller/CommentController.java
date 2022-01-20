package com.example.communication.controller;

import com.example.communication.dto.CommentCreateDto;
import com.example.communication.dto.CommentDto;
import com.example.communication.dto.ResultDto;
import com.example.communication.enums.CommentTypeEnum;
import com.example.communication.exception.CustomizeErrorCode;
import com.example.communication.exception.CustomizeErrorException;
import com.example.communication.model.Comment;
import com.example.communication.model.User;
import com.example.communication.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CommentController {
    @Autowired
    CommentService commentService;

    @ResponseBody
    @PostMapping("/comment")
    public Object comment(@RequestBody CommentCreateDto commentDto, HttpServletRequest request) {
        System.out.println("调用comment接口");
        Comment comment = new Comment();
        if (request.getSession().getAttribute("user") == null) {
            throw new CustomizeErrorException(CustomizeErrorCode.UserNotFound);
        }
        User user = (User) request.getSession().getAttribute("user");
        comment.setCommentator(user.getId());
//        comment.setCommentator(22L);
        comment.setContent(commentDto.getContent());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(comment.getGmtCreate());
        comment.setLikeCount(0L);
        comment.setParentId(commentDto.getParentId());
        if (commentDto.getType() == null || !CommentTypeEnum.isType(commentDto.getType())) {
            throw new CustomizeErrorException(CustomizeErrorCode.CommentTypeNotFound);
        }
        comment.setType(commentDto.getType());
        commentService.insertComment(comment);
        ResultDto resultDto = ResultDto.okOf();
        return resultDto;
    }

    @ResponseBody
    @GetMapping("/comment/{id}")
    public Object commentList(@PathVariable(name = "id") Long id,
                              HttpServletRequest request) {
        System.out.println("调用comment二级评论接口");
        // 查询评论列表
        List<CommentDto> subCommentDtos = commentService.list(id, CommentTypeEnum.COMMENT);
        System.out.println("subComentDtos:" + subCommentDtos);
        ResultDto resultDto = ResultDto.okOf(subCommentDtos);
        return resultDto;

    }
}
