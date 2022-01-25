package com.example.communication.mapper;

import com.example.communication.model.Notification;
import com.example.communication.model.NotificationExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface NotificationExtMapper {
    List<Notification> selectById(Notification notification);
}