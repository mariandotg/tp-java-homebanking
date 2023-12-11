package com.example.tpjavahomebanking.models.dtos;

import com.example.tpjavahomebanking.models.enums.AccountType;
import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDTO {
    private Long id;

    private AccountType type;

    private String cbu;

    private String alias;

    private BigDecimal amount;
}
