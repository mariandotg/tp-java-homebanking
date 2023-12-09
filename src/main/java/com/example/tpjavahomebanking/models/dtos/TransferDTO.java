package com.example.tpjavahomebanking.models.dtos;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder


public class TransferDTO {
    private Long id;
    private Long origin;
    private Long target;
    private Long date;

    private BigDecimal amount;

}

