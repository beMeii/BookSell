package com.prm.group6.services;

import com.google.firebase.messaging.FirebaseMessagingException;

import java.util.List;

public interface FirebaseMessagingService {
    void sendNotifications(String title, String body, List<String> tokens) throws FirebaseMessagingException;
}
