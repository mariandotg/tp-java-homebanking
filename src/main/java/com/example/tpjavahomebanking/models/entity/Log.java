package com.example.tpjavahomebanking.models.entity;

import com.example.tpjavahomebanking.models.enums.ActionType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "logs")
@Getter
@Setter
@Builder
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date;

    private ActionType action;

    private String message;
}