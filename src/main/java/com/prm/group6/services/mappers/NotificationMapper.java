package com.prm.group6.services.mappers;

import com.prm.group6.model.dto.NotificationDTO;
import com.prm.group6.model.entity.Notification;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NotificationMapper {
    NotificationMapper INSTANCE = Mappers.getMapper(NotificationMapper.class);
    NotificationDTO notificationToNotificationDto(Notification notification);
    Notification notificationDtoToNotification(NotificationDTO notificationDTO);
}
