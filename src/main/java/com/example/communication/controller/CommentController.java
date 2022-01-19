package com.example.communication.controller;

import com.example.communication.dto.CommentCreateDto;
import com.example.communication.enums.CommentTypeEnum;
import com.example.communication.exception.CustomizeErrorCode;
import com.example.communication.exception.CustomizeErrorException;
import com.example.communication.model.Comment;
import com.example.communication.model.User;
import com.example.communication.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
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
        Map<Object, Object> resultMap = new HashMap<Object, Object>();
        resultMap.put("retCode", 200);
        resultMap.put("retMsg", "评论成功");
        return resultMap;
    }
}
