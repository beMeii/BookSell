package com.prm.group6.services;

import com.prm.group6.model.dto.BookDTO;
import com.prm.group6.model.dto.GenreDTO;
import com.prm.group6.model.dto.NotificationDTO;
import com.prm.group6.model.entity.Notification;

import java.util.List;

public interface NotificationService {
    List<NotificationDTO> getNotificationList(String token);
    NotificationDTO addNotification(NotificationDTO notificationDto, int customerId);

//    List<BookDTO> removeFavourite(String token, int bookId);
}
