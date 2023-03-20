package com.prm.group6.services.implement;

import com.prm.group6.model.dto.BookDTO;
import com.prm.group6.model.dto.NotificationDTO;
import com.prm.group6.model.entity.Account;
import com.prm.group6.model.entity.Book;
import com.prm.group6.model.entity.Favourite;
import com.prm.group6.model.entity.Notification;
import com.prm.group6.repositories.AccountRepository;
import com.prm.group6.repositories.NotificationRepository;
import com.prm.group6.services.JwtService;
import com.prm.group6.services.NotificationService;
import com.prm.group6.services.mappers.BookMapper;
import com.prm.group6.services.mappers.NotificationMapper;
import org.hibernate.sql.ast.tree.expression.Over;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    NotificationRepository notificationRepository;
    @Autowired
    JwtService jwtService;
    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<NotificationDTO> getNotificationList(String token) {
        Account acc = jwtService.getAccount(token);
        List<Notification> notificationList = notificationRepository.findAllByAccountAccountId(acc.getAccountId());

        List<NotificationDTO> notificationDtoList = new ArrayList<>();
        notificationList.forEach(notification -> {
                    NotificationDTO notificationDTO = NotificationMapper.INSTANCE.notificationToNotificationDto(notification);
                    notificationDtoList.add(notificationDTO);
                }
        );
        return notificationDtoList;
    }

    @Override
    public NotificationDTO addNotification(NotificationDTO notificationDto, int customerId) {
        System.out.println("hello");
        Account acc = accountRepository.getByAccountId(customerId);

        Notification notification = new Notification();
        notification.setTitle(notificationDto.getTitle());
        notification.setBody(notificationDto.getBody());
        notification.setTime(new Timestamp(System.currentTimeMillis()));
        notification.setAccount(acc);

        notificationRepository.save(notification);
        NotificationDTO notificationDTO = NotificationMapper.INSTANCE.notificationToNotificationDto(notification);

        return notificationDTO;
    }
}
