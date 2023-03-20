package com.prm.group6.controllers;

import com.prm.group6.model.dto.BookDTO;
import com.prm.group6.model.dto.NotificationDTO;
import com.prm.group6.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {
    @Autowired
    NotificationService notificationService;

    @GetMapping("/retrieve")
    public ResponseEntity<List<NotificationDTO>> getNotificationListList(@RequestHeader(name = "Authorization") String token) {
        return ResponseEntity.ok(notificationService.getNotificationList(token));
    }

    @PostMapping("/add/{customerId}")
    public ResponseEntity<NotificationDTO> addNotification(
            @RequestBody NotificationDTO notificationDTO,
            @PathVariable("customerId") int customerId) {
        return ResponseEntity.ok(notificationService.addNotification(notificationDTO, customerId));
    }

}
