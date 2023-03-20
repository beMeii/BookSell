package com.prm.group6.model.dto;

import lombok.*;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class NotificationDTO {
    private int notificationId;
    private String title;
    private String body;
    private Timestamp time;
}
