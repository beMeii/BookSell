package com.prm.group6.services.implement;

import com.prm.group6.model.dto.PushNotificationRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PushNotificationService {
    private Logger logger = LoggerFactory.getLogger(PushNotificationService.class);

    @Autowired
    private FCMServiceImpl fcmService;

    public void sendNotificationToToken(PushNotificationRequest request){
        try{
            fcmService.sendMessageToToken(request);
        } catch (Exception e){
            logger.error(e.getMessage());
        }
    }
}
