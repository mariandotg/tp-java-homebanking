package com.example.tpjavahomebanking.models.dtos;

import com.example.tpjavahomebanking.models.enums.ActionType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class LogDTO {
    private Long id;

    private LocalDateTime date;

    private ActionType action;

    private String message;
}
