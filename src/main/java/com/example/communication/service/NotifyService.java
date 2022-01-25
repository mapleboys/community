package com.example.communication.service;

import com.example.communication.dto.NotificationDto;
import com.example.communication.enums.CommentTypeEnum;
import com.example.communication.enums.NotifyStatusEnum;
import com.example.communication.enums.NotifyTypeEnum;
import com.example.communication.mapper.CommentMapper;
import com.example.communication.mapper.NotificationMapper;
import com.example.communication.mapper.QuestionMapper;
import com.example.communication.mapper.UserMapper;
import com.example.communication.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NotifyService {

    @Autowired
    NotificationMapper notificationMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    QuestionMapper questionMapper;
    @Autowired
    CommentMapper commentMapper;

    public void incNotifyRecord(Comment comment) {
        Notification notification = new Notification();
        notification.setGmtCreate(System.currentTimeMillis());
        notification.setNotifier(comment.getCommentator());
        notification.setOuterid(comment.getParentId());

        User user = userMapper.selectByPrimaryKey(comment.getCommentator());
        notification.setNotifierName(user.getName());
        notification.setStatus(0);  //默认0，未读；1，已读

        // 根据回复评论或回复问题写入不同类型
        if (comment.getType() == CommentTypeEnum.QUESTION.getType()) {
            notification.setType(NotifyTypeEnum.ReplyQuestionNotify.getType());
            Question question = questionMapper.selectByPrimaryKey(comment.getParentId());
            Long creator = question.getCreator();
            notification.setReceiver(creator);
            notification.setOutertitle(question.getTitle());
        } else if (comment.getType() == CommentTypeEnum.COMMENT.getType()) {
            notification.setType(NotifyTypeEnum.ReplyCommentNotify.getType());
            Comment commentPar = commentMapper.selectByPrimaryKey(comment.getParentId());
            Long commentator = commentPar.getCommentator();
            notification.setReceiver(commentator);
            notification.setOutertitle(commentPar.getContent());
        }
        notificationMapper.insert(notification);
    }
    //更新通知阅读状态
    public Long read(Long id) {
        Notification notification = notificationMapper.selectByPrimaryKey(id);
        if(notification.getStatus() == NotifyStatusEnum.unread.getValue()) {
            notification.setStatus(NotifyStatusEnum.read.getValue());
            notificationMapper.updateByPrimaryKey(notification);
        }
        Long parentId = notification.getOuterid();
        if (notification.getType() == CommentTypeEnum.COMMENT.getType()) {
            parentId = commentMapper.selectByPrimaryKey(notification.getOuterid()).getParentId();
        }
        return parentId;
    }

    public List<NotificationDto> list(Long id) {
        NotificationExample notificationExample = new NotificationExample();
        notificationExample.createCriteria().andReceiverEqualTo(id);
        List<Notification> notifications = notificationMapper.selectByExample(notificationExample);
        System.out.println("notifications:" + notifications);
        ArrayList<NotificationDto> notificationDtos = new ArrayList<>();
        for (Notification notification : notifications) {
            NotificationDto notificationDto = new NotificationDto();
            BeanUtils.copyProperties(notification, notificationDto);
            Integer type = notificationDto.getType();
            String actionByType = NotifyTypeEnum.getActionByType(type);
            notificationDto.setNotifyAction(actionByType);
            notificationDtos.add(notificationDto);
        }
        return notificationDtos;
    }
}
