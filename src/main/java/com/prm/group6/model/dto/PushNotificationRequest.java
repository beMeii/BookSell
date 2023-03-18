package com.prm.group6.model.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PushNotificationRequest {
    private String title;
    private String message;
    private String topic;
    private String token;
}
