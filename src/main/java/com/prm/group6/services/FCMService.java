package com.prm.group6.services;

import com.prm.group6.model.dto.PushNotificationRequest;

import java.util.concurrent.ExecutionException;

public interface FCMService {

    void sendMessageToToken(PushNotificationRequest request) throws InterruptedException, ExecutionException;

}
