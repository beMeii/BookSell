package com.prm.group6.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity(name = "Notification")
@Table(name = "notifications")
@Data
@Getter
@Setter
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private int notificationId;
    @Column(name = "title")
    private String title;
    @Column(name = "body")
    private String body;
    @Column(name = "time")
    private Timestamp time;
    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    @NotNull
    private Account account;
}
