package com.prm.group6.services.implement;

import com.google.firebase.messaging.*;
import com.prm.group6.services.FCMService;
import com.prm.group6.services.FirebaseMessagingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FirebaseMessagingServiceImpl implements FirebaseMessagingService {
    private Logger logger = LoggerFactory.getLogger(PushNotificationService.class);
//    @Autowired
//    private FirebaseMessaging firebaseMessaging;
//
//    public FirebaseMessagingServiceImpl(FirebaseMessaging firebaseMessaging) {
//        this.firebaseMessaging = firebaseMessaging;
//    }

    @Autowired
    private FirebaseMessaging firebaseMessaging;

    @Autowired
    private FCMService fcmService;

    public FirebaseMessagingServiceImpl(FirebaseMessaging firebaseMessaging) {
        this.firebaseMessaging = firebaseMessaging;
    }

    @Override
    public void sendNotifications(String title, String body, List<String> tokens) throws FirebaseMessagingException {
        MulticastMessage message = MulticastMessage.builder()
                .setNotification(Notification.builder()
                        .setTitle(title)
                        .setBody(body)
                        .build())
                .addAllTokens(tokens)
                .build();

        BatchResponse response = firebaseMessaging.sendMulticast(message);

        System.out.println("Notifications sent successfully: " + response.getSuccessCount());
    }
}
