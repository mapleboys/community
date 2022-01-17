package com.example.communication.controller;

import com.example.communication.dto.CommentDto;
import com.example.communication.exception.CustomizeErrorCode;
import com.example.communication.exception.CustomizeErrorException;
import com.example.communication.model.Comment;
import com.example.communication.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/comment")
    public Object comment(@RequestBody CommentDto commentDto) {
        Comment comment = new Comment();
//        if (request.getSession().getAttribute("user") == null) {
//            throw new CustomizeErrorException(CustomizeErrorCode.QuestionNotFound);
//        }
//        comment.setCommentator((Integer) request.getSession().getAttribute("user"));
        comment.setCommentator(22);
        comment.setContent(commentDto.getContent());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(comment.getGmtCreate());
        comment.setLikeCount(0L);
        if (commentDto.getType() == null || !commentService.isType(commentDto.getType())) {
            throw new CustomizeErrorException(CustomizeErrorCode.CommentTypeNotFound);
        }
        comment.setType(commentDto.getType());
        commentService.insert(comment);
        Map<Object, Object> resultMap = new HashMap<Object, Object>();
        resultMap.put("retCode", 200);
        resultMap.put("retMsg", "评论成功");
        return resultMap;
    }
}
